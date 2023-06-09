package com.produtos.apirest.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

}
