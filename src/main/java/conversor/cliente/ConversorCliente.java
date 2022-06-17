package conversor.cliente;

import com.proto.conversor.ConversorRequest;
import com.proto.conversor.ConversorResponse;
import com.proto.conversor.ConversorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ConversorCliente {
    public static void main(String[] args) {

        TelaCliente tela = new TelaCliente();
        tela.setVisible(true);

    }


}
