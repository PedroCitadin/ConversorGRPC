package conversor.cliente;

import com.proto.conversor.ConversorRequest;
import com.proto.conversor.ConversorResponse;
import com.proto.conversor.ConversorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class TelaCliente extends JFrame {
       private JLabel labelTitulo;
       private JTextField txtmoedaInicial;
       private JLabel labelValorFinal;
       private JComboBox<String> moedaInicial;
       private JComboBox<String> moedaFinal;
       private JButton btnConverte;


       public TelaCliente(){
           this.setSize(500, 400);
           setResizable(false);
           setTitle("Conversor de Moedas");
           setLayout(null);
           setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           criaComponentes();


       }

       public void criaComponentes(){
                labelTitulo = new JLabel();
                labelTitulo.setFont(new Font("Tahoma", 0, 18));
                labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
                labelTitulo.setText("Conversor de Moedas");
                labelTitulo.setBounds(0, 0, 500, 30);
                getContentPane().add(labelTitulo);

                txtmoedaInicial = new JTextField();
                txtmoedaInicial.setBounds(5, 50, 200, 25);
                getContentPane().add(txtmoedaInicial);

                moedaInicial = new JComboBox<String>();
                moedaInicial.setBounds(210, 50, 100, 25);
                moedaInicial.setModel(new DefaultComboBoxModel<>(new String[] { "Real", "Dolar", "Euro", "Libra" }));

                getContentPane().add(moedaInicial);

                btnConverte = new JButton();
                btnConverte.setText("Converter");
                btnConverte.setBounds(350, 50, 125, 25);
                btnConverte.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (moedaInicial.getSelectedIndex()!=moedaFinal.getSelectedIndex()) {





                            ////cria o cananal de comunicação com a porta do servidor
                            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

                            ////cria o stub para identificar o metodo a ser utilizado
                            ConversorServiceGrpc.ConversorServiceBlockingStub stub = ConversorServiceGrpc.newBlockingStub(channel);

                            ////passa os parametros da request
                            ConversorRequest request = ConversorRequest.newBuilder()
                                    .setValor(Double.parseDouble(txtmoedaInicial.getText()))
                                    .setMoedaatual(String.valueOf(moedaInicial.getSelectedIndex()))
                                    .setMooedafinal(String.valueOf(moedaFinal.getSelectedIndex()))
                                    .build();

                            /////pega a resposta chamando o metodo
                            ConversorResponse response = stub.conversor(request);
                            labelValorFinal.setText(new DecimalFormat("#,##0.00").format(response.getValorfinal()));


                            ////fecha o canal
                            channel.shutdown();
                        }
                    }
                });
                getContentPane().add(btnConverte);

                moedaFinal = new JComboBox<String>();
                moedaFinal.setBounds(5, 90, 100, 25);
                moedaFinal.setModel(new DefaultComboBoxModel<>(new String[] { "Real", "Dolar", "Euro", "Libra" }));
                getContentPane().add(moedaFinal);

                labelValorFinal = new JLabel();
                labelValorFinal.setText("");
                labelValorFinal.setBounds(115, 90, 100, 25);
                labelValorFinal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                getContentPane().add(labelValorFinal);



       }

}
