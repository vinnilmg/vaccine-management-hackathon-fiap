package com.fiap.hackathon.ms_postos_vacina.service;

import com.fiap.hackathon.ms_postos_vacina.controller.request.LoteRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoUpdateRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.response.LoteResponse;
import com.fiap.hackathon.ms_postos_vacina.controller.response.PostoResponse;

import java.util.List;

public interface PostoService {
    List<PostoResponse> buscaPostos();

    PostoResponse buscaPosto(Long id);

    List<PostoResponse> buscaPorBairro(String bairro);

    PostoResponse criaPosto(PostoRequest request);

    PostoResponse atualizaPosto(Long id, PostoUpdateRequest request);

    LoteResponse criaLote(LoteRequest request);

    void aumentarEstoque(Long idPosto, Long vacinaId);

    void diminuirEstoque(Long idPosto, Long vacinaId);

    LoteResponse buscaPostoLote(Long idPosto, Long vacinaId);

    LoteResponse buscaNrLote(String idLote);
}
