package com.fiap.hackathon.ms_postos_vacina.service;

import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoUpdateRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.response.PostoResponse;

import java.util.List;

public interface PostoService {
    List<PostoResponse> buscaPostos();

    PostoResponse buscaPosto(Long id);

    List<PostoResponse> buscaPorBairro(String bairro);

    PostoResponse criaPosto(PostoRequest request);

    PostoResponse atualizaPosto(Long id, PostoUpdateRequest request);
}
