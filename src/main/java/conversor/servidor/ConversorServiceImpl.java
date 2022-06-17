package conversor.servidor;

import com.proto.conversor.ConversorRequest;
import com.proto.conversor.ConversorResponse;
import com.proto.conversor.ConversorServiceGrpc;
import io.grpc.stub.CallStreamObserver;
import io.grpc.stub.StreamObserver;

public class ConversorServiceImpl extends ConversorServiceGrpc.ConversorServiceImplBase {

    /////classe de implementação
    @Override
    public void conversor(ConversorRequest request, StreamObserver<ConversorResponse> responseObserver) {
        ///// faz a conversão por meio da API utilizando os valores que vem da requisição
        float aux;
        Conversao conv = new Conversao((float) request.getValor(),Integer.parseInt(request.getMoedaatual()), Integer.parseInt(request.getMooedafinal()));
        aux = conv.converte(conv);

        ////cria a resposta da requisição
        ConversorResponse response = ConversorResponse.newBuilder().setValorfinal(aux).build();


        /////envia a resposta e completa a execução
        responseObserver.onNext(response);
        responseObserver.onCompleted();
       // super.conversor(request, responseObserver);
    }
}
