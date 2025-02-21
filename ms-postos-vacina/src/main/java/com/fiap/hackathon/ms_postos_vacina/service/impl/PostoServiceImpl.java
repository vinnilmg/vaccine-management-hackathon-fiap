package com.fiap.hackathon.ms_postos_vacina.service.impl;

import com.fiap.hackathon.ms_postos_vacina.controller.mapper.LoteResponseMapper;
import com.fiap.hackathon.ms_postos_vacina.controller.mapper.PostoResponseMapper;
import com.fiap.hackathon.ms_postos_vacina.controller.request.LoteRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoUpdateRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.response.LoteResponse;
import com.fiap.hackathon.ms_postos_vacina.controller.response.PostoResponse;
import com.fiap.hackathon.ms_postos_vacina.exception.*;
import com.fiap.hackathon.ms_postos_vacina.repository.EnderecoRepository;
import com.fiap.hackathon.ms_postos_vacina.repository.FuncionamentoRepository;
import com.fiap.hackathon.ms_postos_vacina.repository.LoteRepository;
import com.fiap.hackathon.ms_postos_vacina.repository.PostoRepository;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.EnderecoEntity;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.LoteEntity;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.FuncionamentoEntity;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.PostoEntity;
import com.fiap.hackathon.ms_postos_vacina.repository.mapper.EnderecoMapper;
import com.fiap.hackathon.ms_postos_vacina.repository.mapper.FuncionamentoMapper;
import com.fiap.hackathon.ms_postos_vacina.repository.mapper.LoteMapper;
import com.fiap.hackathon.ms_postos_vacina.repository.mapper.PostoMapper;
import com.fiap.hackathon.ms_postos_vacina.service.PostoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PostoServiceImpl implements PostoService {
    @Autowired
    private PostoRepository postoRepository;
    @Autowired
    private PostoResponseMapper postoResponseMapper;
    @Autowired
    private PostoMapper postoMapper;
    @Autowired
    private EnderecoMapper enderecoMapper;
    @Autowired
    private FuncionamentoMapper funcionamentoMapper;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private FuncionamentoRepository funcionamentoRepository;
    @Autowired
    private LoteMapper loteMapper;
    @Autowired
    private LoteRepository loteRepository;
    @Autowired
    private LoteResponseMapper loteResponseMapper;

    @Override
    public List<PostoResponse> buscaPostos() {
        return postoRepository.findAll()
                .stream()
                .map(postoResponseMapper::toPostoResponse)
                .toList();
    }

    @Override
    public PostoResponse buscaPosto(Long id) {
        return postoRepository.findById(id)
                .map(postoResponseMapper::toPostoResponse)
                .orElseThrow(PostoNotFoundException::new);
    }

    @Override
    public List<PostoResponse> buscaPorBairro(String bairro) {
        return postoRepository.findByEnderecoBairro(bairro)
                .stream()
                .map(postoResponseMapper::toPostoResponse)
                .toList();
    }

    @Transactional
    @Override
    public PostoResponse criaPosto(PostoRequest request) {
        EnderecoEntity endereco = enderecoMapper.toEndereco(request.endereco());
        PostoEntity posto = postoMapper.toPosto(request);

        posto.setEndereco(endereco);
        endereco.setPosto(posto);
        posto.getFuncionamento().forEach(f -> f.setPosto(posto));

        PostoEntity postoSaved = postoRepository.save(posto);
        return postoResponseMapper.toPostoResponse(postoSaved);
    }

    @Override
    public PostoResponse atualizaPosto(Long id, PostoUpdateRequest postoUpdateRequest) {
        PostoEntity posto = postoRepository.findById(id)
                .orElseThrow(PostoNotFoundException::new);

        List<FuncionamentoEntity> funcionamento =
                funcionamentoMapper.toFuncionamentoList(postoUpdateRequest.funcionamentoRequestList());

        posto.setNome(postoUpdateRequest.nome());
        posto.setStatus(postoUpdateRequest.statusPostoEnum());
        posto.setFuncionamento(funcionamento);
        return postoResponseMapper.toPostoResponse(postoRepository.save(posto));
    }

    @Transactional
    @Override
    public LoteResponse criaLote(LoteRequest request) {
        LoteEntity lote = loteMapper.toLote(request);

        if(lote.getEstoque() <= 0){
            throw new EstoqueInvalidoException();
        }

        LocalDate futureDate = LocalDate.parse(lote.getValidade());
        LocalDate today = LocalDate.now();

        if (!futureDate.isAfter(today)) {
            throw new DataInvalidaException();
        }

        LoteEntity loteSaved = loteRepository.save(lote);
        return loteResponseMapper.toLoteResponse(loteSaved);
    }

    @Override
    public void aumentarEstoque(Long idPosto, Long vacinaId) {
        var loteOp = loteRepository.findByPostoVacinacaoIdAndVacinaId(idPosto, vacinaId);
        if(loteOp.isEmpty()) throw new PostoVacinaNotFoundException();

        var lote = loteOp.get();
        lote.setEstoque(lote.getEstoque() + 1) ;
        loteRepository.save(lote);
    }

    @Override
    public void diminuirEstoque(Long idPosto, Long vacinaId) {
        var loteOp = loteRepository.findByPostoVacinacaoIdAndVacinaId(idPosto, vacinaId);
        if(loteOp.isEmpty()) throw new PostoVacinaNotFoundException();

        var lote = loteOp.get();
        lote.setEstoque(lote.getEstoque() - 1) ;
        loteRepository.save(lote);
    }

    @Override
    public LoteResponse buscaPostoLote(Long idPosto, Long vacinaId) {
        var registro = loteRepository.findByPostoVacinacaoIdAndVacinaId(idPosto, vacinaId);

        if (registro.isEmpty()) throw new PostoVacinaNotFoundException();
        return loteResponseMapper.toLoteResponse(registro.get());
    }

    @Override
    public LoteResponse buscaNrLote(String idLote) {
        var registro = loteRepository.findByNumero(idLote);

        if (registro.isEmpty()) throw new LoteNotFoundException();
        return loteResponseMapper.toLoteResponse(registro.get());
    }
}
