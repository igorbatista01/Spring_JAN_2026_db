package br.senai.sp.teste.mapper;

import java.util.ArrayList;
import java.util.List;

import br.senai.sp.teste.DTO.CategoriaListDTO;
import br.senai.sp.teste.model.Categoria;

public class CategoriaMapper {

	public static CategoriaListDTO toDto(Categoria c) {
		return new CategoriaListDTO(c.getId(), c.getDescricao());
	}
	
	public static Categoria toCategoria(CategoriaListDTO dto) {
		Categoria c = new Categoria();
		c.setId(dto.id());
		c.setDescricao(dto.descricao());
		return c;
	}
	
	public static List<CategoriaListDTO> toListDTO(List<Categoria> lista) {
		List<CategoriaListDTO> listaDTO = new ArrayList<>();
		for (Categoria categoria: lista) {
			listaDTO.add(toDto(categoria));
			
		}
		return listaDTO;
	}
}
