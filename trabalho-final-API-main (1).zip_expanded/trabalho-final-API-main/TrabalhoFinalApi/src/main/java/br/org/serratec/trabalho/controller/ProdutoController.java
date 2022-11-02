package br.org.serratec.trabalho.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.trabalho.domain.Produto;
import br.org.serratec.trabalho.dto.ProdutoDTO;
import br.org.serratec.trabalho.dto.ProdutoInserirDTO;
import br.org.serratec.trabalho.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> buscaTodos() {
		List<Produto> produtos = produtoService.buscarTodos();
		return ResponseEntity.ok(produtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) {
		Produto produto = produtoService.buscaPorId(id);
		return ResponseEntity.ok(produto);
	}

	@GetMapping("/imagem/{id}")
	public ResponseEntity<byte[]> buscarFoto(@PathVariable Long id) {
		Produto produto = produtoService.buscaPorId(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", produto.getTipoArquivo());
		headers.add("Content-length", String.valueOf(produto.getImagem().length));
		return new ResponseEntity<>(produto.getImagem(), headers, HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<ProdutoDTO> inserir(@RequestPart MultipartFile file,
			@Valid @RequestPart(name = "produto") ProdutoInserirDTO produtoInserir) throws IOException {
		ProdutoDTO produto = produtoService.incluir(produtoInserir, file);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getIdProduto())
				.toUri();
		return ResponseEntity.created(uri).body(produto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.alterar(id, produto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}