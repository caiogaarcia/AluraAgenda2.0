package br.com.alura.agenda.services;

//trabalha junto com o Retrofit

import br.com.alura.agenda.modelo.Aluno;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AlunoService {

    @POST("aluno") // METODO(CHAMADA) -> o resto ele pega do endereco base

        // Forma com que o retrofit utiliza para fazer as chamadas (@Body -> significa que ele vai pegar o objeto transformar em JSON e deixar no corpo da requisicao
        Call<Void> insere(@Body Aluno aluno);

}
