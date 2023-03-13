package com.produtos.apirest.resources;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaPoodutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }

    @GetMapping("/produto/{id}")
    public Produto listarUmProduto(@PathVariable(value = "id") UUID id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }

    @PostMapping("/produto")
    public Produto salvarProduto(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoSalvo;
    }

    @DeleteMapping("/produto")
    public void deletarProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

}
