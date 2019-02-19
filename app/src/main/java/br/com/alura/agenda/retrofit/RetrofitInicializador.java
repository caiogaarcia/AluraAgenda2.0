package br.com.alura.agenda.retrofit;

import br.com.alura.agenda.services.AlunoService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitInicializador {

    private final Retrofit retrofit;

    public RetrofitInicializador(){

        // eh um filtro que sempre fica observando qdo acontece requisicao, e entao detalha todo o ciclo de vida dela
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //nivel de detalhe para cada requisicao

        //nivel do interceptador
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // criamos um cliente do tipo OkHttp para mandar para o retrofit
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        client.addInterceptor(interceptor);

        // URL BASE e CONVERSOR AUTOMATICO
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.11:8080/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public AlunoService getAlunoService() {
        return retrofit.create(AlunoService.class);
    }
}
