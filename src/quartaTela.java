import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quartaTela extends JFrame implements ActionListener {
    private JButton btnCadastrar;
    private JButton btnRelatorio;
    private JLabel lblPeso;
    private JTextField txtPeso;
    private JLabel lblAltura;
    private JTextField txtAltura;
    private JLabel lblResultado;
    private JLabel lblMSG;
    private JLabel lblIMC;
    private JLabel lblMaiorP;
    private JLabel lblMenorP;
    private JLabel lblMediaAllP;
    private JLabel lblMaiorAlt;
    private JLabel lblMenorAlt;
    private JLabel lblMediaAllAlt;
    private JLabel lblMediaAllIMC;
    private JLabel lblMaiorIMC;
    private JLabel lblMenorIMC;
    private Container ctn;
    private MassaCorporal massaCorporal;

    public quartaTela() {
        setSize(320, 480);
        setTitle("Calculo IMC");
        ctn = getContentPane();
        ctn.setLayout(null);

        lblPeso = new JLabel("Peso");
        lblAltura = new JLabel("Altura");
        txtPeso = new JTextField();
        txtAltura = new JTextField();
        lblResultado = new JLabel("--");
        lblMSG = new JLabel("Mensagem: ");
        lblIMC = new JLabel("Seu IMC é: ");
        lblMaiorP = new JLabel("Maior Peso: ");
        lblMenorP = new JLabel("Menor Peso: ");
        lblMediaAllP = new JLabel("Média de todos os pesos: ");
        lblMaiorAlt = new JLabel("Maior Altura: ");
        lblMenorAlt = new JLabel("Menor Altura: ");
        lblMediaAllAlt = new JLabel("Média de todas as alturas: ");
        lblMediaAllIMC = new JLabel("Média de todos os IMCs: ");
        lblMaiorIMC = new JLabel("Maior IMC: ");
        lblMenorIMC = new JLabel("Menor IMC: ");

        lblAltura.setBounds(10, 10, 100, 25);
        txtAltura.setBounds(50, 10, 100, 25);
        lblPeso.setBounds(160, 10, 100, 25);
        txtPeso.setBounds(200, 10, 100, 25);
        lblIMC.setBounds(10, 40, 120, 25);
        lblResultado.setBounds(80, 40, 200, 25);
        lblMSG.setBounds(10, 70, 240, 25);
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(50, 400, 100, 30);
        btnRelatorio = new JButton("Relatório");
        btnRelatorio.setBounds(150, 400, 100, 30);
        lblMaiorP.setBounds(10, 100, 240, 25);
        lblMenorP.setBounds(10, 130, 240, 25);
        lblMediaAllP.setBounds(10, 160, 240, 25);
        lblMaiorAlt.setBounds(10, 190, 240, 25);
        lblMenorAlt.setBounds(10, 220, 240, 25);
        lblMediaAllAlt.setBounds(10, 250, 240, 25);
        lblMediaAllIMC.setBounds(10, 280, 240, 25);
        lblMaiorIMC.setBounds(10, 310, 240, 25);
        lblMenorIMC.setBounds(10, 340, 240, 25);

        ctn.add(lblAltura);
        ctn.add(txtAltura);
        ctn.add(lblPeso);
        ctn.add(txtPeso);
        ctn.add(lblIMC);
        ctn.add(lblResultado);
        ctn.add(lblMSG);
        ctn.add(btnCadastrar);
        ctn.add(btnRelatorio);
        ctn.add(lblMaiorP);
        ctn.add(lblMenorP);
        ctn.add(lblMediaAllP);
        ctn.add(lblMaiorAlt);
        ctn.add(lblMenorAlt);
        ctn.add(lblMediaAllAlt);
        ctn.add(lblMediaAllIMC);
        ctn.add(lblMaiorIMC);
        ctn.add(lblMenorIMC);

        btnCadastrar.addActionListener(this);
        btnRelatorio.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        massaCorporal = new MassaCorporal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastrar) {
            cadastrar();
        } else if (e.getSource() == btnRelatorio) {
            exibirRelatorio();
        }
    }

    private void cadastrar() {
        try {
            double peso = Double.parseDouble(txtPeso.getText());
            double altura = Double.parseDouble(txtAltura.getText());

            massaCorporal.cadastrar(peso, altura);
            lblMSG.setText("Cadastro realizado com sucesso!");
            atualizarIMC();
        } catch (NumberFormatException ex) {
            lblMSG.setText("Erro: Preencha corretamente os campos Peso e Altura.");
        }
    }

    private void exibirRelatorio() {

        lblMaiorP.setText("Maior Peso: " + String.format("%.2f", massaCorporal.maiorPeso()));
        lblMenorP.setText("Menor Peso: " + String.format("%.2f", massaCorporal.menorPeso()));
        lblMediaAllP.setText("Média de todos os pesos: " + String.format("%.2f", massaCorporal.mediaPeso()));

        lblMaiorAlt.setText("Maior Altura: " + String.format("%.2f", massaCorporal.maiorAltura()));
        lblMenorAlt.setText("Menor Altura: " + String.format("%.2f", massaCorporal.menorAltura()));
        lblMediaAllAlt.setText("Média de todas as alturas: " + String.format("%.2f", massaCorporal.mediaAltura()));


        lblMaiorIMC.setText("Maior IMC: " + String.format("%.2f", massaCorporal.maiorIMC()));
        lblMenorIMC.setText("Menor IMC: " + String.format("%.2f", massaCorporal.menorIMC()));
        lblMediaAllIMC.setText("Média de todos os IMCs: " + String.format("%.2f", massaCorporal.mediaIMC()));
    }

    private void atualizarIMC() {
        double ultimoIMC = massaCorporal.ultimoIMC();
        lblResultado.setText(Double.isNaN(ultimoIMC) ? "--" : String.format("%.2f", ultimoIMC));
    }

    public static void main(String[] args) {
        quartaTela t4 = new quartaTela();
    }
}


