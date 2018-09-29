package br.pucminas.integracao.bi.worker.eai;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.pucminas.integracao.bi.worker.model.Pessoa;

public class PessoaMapper implements RowMapper<Pessoa>{

	@Override
	public Pessoa mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(rs.getString("nome"));
		pessoa.setSobrenome(rs.getString("sobrenome"));
		pessoa.setDataNascimento(rs.getString("dataNascimento"));
		return pessoa;
	}

}
