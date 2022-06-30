package br.com.alura.rh.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida) {

        if (funcionario.getDadosPessoais().getCargo() == Cargo.GERENTE) {
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }

        Cargo cargoAtual = funcionario.getDadosPessoais().getCargo();

        if (metaBatida) {
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        } else {
            throw new ValidacaoException("Funcionário não bateu a meta!");
        }
    }
}
