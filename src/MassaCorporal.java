import java.util.*;

public class MassaCorporal {
    private ArrayList<Double> alturaList;
    private ArrayList<Double> pesoList;
    private ArrayList<Double> imcList;

    public MassaCorporal() {
        alturaList = new ArrayList<>();
        pesoList = new ArrayList<>();
        imcList = new ArrayList<>();
    }

    public void cadastrar(double peso, double altura) {
        alturaList.add(altura);
        pesoList.add(peso);
        imcList.add(calcularIMC(peso, altura));
    }

    private double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    private double calcularMedia(ArrayList<Double> list) {
        if (list.isEmpty()) {
            return Double.NaN;
        }
        double sum = 0;
        for (double value : list) {
            sum += value;
        }
        return sum / list.size();
    }

    private double encontrarMaior(ArrayList<Double> list) {
        return list.isEmpty() ? Double.NaN : Collections.max(list);
    }

    private double encontrarMenor(ArrayList<Double> list) {
        return list.isEmpty() ? Double.NaN : Collections.min(list);
    }

    public double maiorPeso() {
        return encontrarMaior(pesoList);
    }

    public double menorPeso() {
        return encontrarMenor(pesoList);
    }

    public double mediaPeso() {
        return calcularMedia(pesoList);
    }

    public double maiorAltura() {
        return encontrarMaior(alturaList);
    }

    public double menorAltura() {
        return encontrarMenor(alturaList);
    }

    public double mediaAltura() {
        return calcularMedia(alturaList);
    }

    public double maiorIMC() {
        return encontrarMaior(imcList);
    }

    public double menorIMC() {
        return encontrarMenor(imcList);
    }

    public double mediaIMC() {
        return calcularMedia(imcList);
    }

    public double ultimoIMC() {
        int lastIndex = imcList.size() - 1;
        return lastIndex >= 0 ? imcList.get(lastIndex) : Double.NaN;
    }



}

