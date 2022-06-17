package conversor.servidor;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ConversorServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Servidor Rodando");

        //////inicia o server
        Server server = ServerBuilder.forPort(50052)
                /////service que vai ser utilizado para a conversão
                .addService(new ConversorServiceImpl())
                .build();
        server.start();

        /////aguarda o comando para fechar o servidor
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Solicitação de encerramento recebida");
            server.shutdown();
            System.out.println("Servidor parado");
        }));



        ///////Aguarda o fechamento
        server.awaitTermination();

    }
}
