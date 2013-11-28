package br.com.redeservico.utilitarios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <code>Data</code> Métodos para tratamento de Data
 */
public class Data {

    /**
     * Retorna a data atual
     * @return CURRENT_DATE
     */
    public static Date dataHoje() {
        Date dateTime = new Date();
        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  data e hora
        return dateTime;
    }

    /**
     * Retorna a data atual convertida em String
     * @return CURRENT_DATE
     */    
    public static String data() {
        Date dateTime = new Date();
        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");   data e hora
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String a = dateFormat.format(dateTime);
        return a;
    }

     /**
     * Retorna data personalizada
     * @param date 
     * @param format (Formato que a (Date) data deverá retornar - yyyy-MM-dd HH:mm:ss - Ex. Entra 2013-01-01 - livre(date, 'dd/MM/yyyy'))
     * @return '01/01/2013'
     */
    public static String livre(Date date, String format) {
        if (format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        String a = dateFormat.format(date);
        return a;
    }
    
    /**
     * Converte Date para String
     * @param data
     * @return 
     */
    public static String converteData(Date data) {
        if (data != null) {
            String a = data.toString();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String b = dateFormat.format(data);
            return b;
        } else {
            return "";
        }
    }

    /**
     * Converte String para Date
     * @param data
     * @return 
     */    
    public static String converteData(String data) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(data);
    }

    /**
     * Converte String para Date
     * @param data
     * @return 
     */      
    public static Date converte(String data) {
        if (data != null) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.parse(data);
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static Date converteDateSql(java.sql.Date date) {
        String data = date.toString();
        if (data != null) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return dateFormat.parse(data);
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String dataReferencia(String data) {
        String referencia = "";
        Data dt = new Data();
        referencia = dt.decrementarMeses(1, data);
        return referencia.substring(3);
    }

    public static String[] ArrayData() {
        String[] result = new String[3];
        result[0] = Data.data().substring(0, 2);
        result[1] = Data.data().substring(3, 5);
        result[2] = Data.data().substring(6, 10);
        return result;
    }

    public static String[] DataToArray(String data) {
        String[] result = new String[3];
        result[0] = data.substring(0, 2);
        result[1] = data.substring(3, 5);
        result[2] = data.substring(6, 10);
        return result;
    }

    public static String[] DataToArray(Date data) {
        String[] result = new String[3];
        result[0] = converteData(data).substring(0, 2);
        result[1] = converteData(data).substring(3, 5);
        result[2] = converteData(data).substring(6, 10);
        return result;
    }

    public static int[] ArrayDataInt() {
        int[] result = new int[3];
        result[0] = Integer.parseInt(Data.data().substring(0, 2));
        result[1] = Integer.parseInt(Data.data().substring(3, 5));
        result[2] = Integer.parseInt(Data.data().substring(6, 10));
        return result;
    }

    public static int[] dataToArrayInt(String data) {
        int[] result = new int[3];
        result[0] = Integer.parseInt(data.substring(0, 2));
        result[1] = Integer.parseInt(data.substring(3, 5));
        result[2] = Integer.parseInt(data.substring(6, 10));
        return result;
    }

    public static int[] dataToArrayInt(Date data) {
        int[] result = new int[3];
        result[0] = Integer.parseInt(converteData(data).substring(0, 2));
        result[1] = Integer.parseInt(converteData(data).substring(3, 5));
        result[2] = Integer.parseInt(converteData(data).substring(6, 10));
        return result;
    }

    public static String[] dataToArrayString(String data) {
        String[] result = new String[3];
        result[0] = data.substring(0, 2);
        result[1] = data.substring(3, 5);
        result[2] = data.substring(6, 10);
        return result;
    }

    public static String[] dataToArrayString(Date data) {
        String[] result = new String[3];
        String dataS = converteData(data);
        result[0] = dataS.substring(0, 2);
        result[1] = dataS.substring(3, 5);
        result[2] = dataS.substring(6, 10);
        return result;
    }

    public static int qtdeDiasDoMes(int mes, int ano) {
        int dias = 0;
        if ((mes == 1)
                || (mes == 3)
                || (mes == 5)
                || (mes == 7)
                || (mes == 8)
                || (mes == 10)
                || (mes == 12)) {
            return 31;
        } else if ((mes == 4)
                || (mes == 6)
                || (mes == 9)
                || (mes == 11)) {
            return 30;
        } else if (mes == 2) {
            if (isBisexto(ano)) {
                return 29;
            } else {
                return 28;
            }
        }

        return dias;
    }

    /**
     * Verifica se o ano é Bisexto
     * @param ano
     * @return ano bisexto
     */
    public static boolean isBisexto(int ano) {
        if ((ano % 4) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static long calculoDosDias(Date dInicial, Date dFinal) {
        Data.converteDataParaInteger(Data.converteData(dInicial));
        Data.converteDataParaInteger(Data.converteData(dFinal));
        if (((dInicial != null) && (dFinal != null))
                && (Data.converteDataParaInteger(Data.converteData(dInicial)) < Data.converteDataParaInteger(Data.converteData(dFinal)))) {
            long dias = dFinal.getTime() - dInicial.getTime();
            long total = dias / 86400000;
            return total;
        } else {
            return 0;
        }
    }

    public static boolean validaReferencias(String refInicial, String refFinal) {
        if (!refInicial.equals("") && !refFinal.equals("")) {
            String d1 = refInicial.substring(3, 7) + refInicial.substring(0, 2);
            int INTrefInicial = Integer.valueOf(d1);
            String d2 = refFinal.substring(3, 7) + refFinal.substring(0, 2);
            int INTrefFinal = Integer.valueOf(d2);
            if (INTrefInicial <= INTrefFinal) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

//    public boolean integridadeReferencia(String referencia){
//        if (referencia.length() != 7)
//            return false;
//        if ((AnaliseString.conteudoData(referencia.substring(0, 2) + referencia.substring(3, 7))) &&
//            (referencia.substring(2, 3).equals("/")) &&
//            (Integer.parseInt(referencia.substring(0, 2)) < 13) &&
//            (Integer.parseInt(referencia.substring(0, 2)) > 0) &&
//            (Integer.parseInt(referencia.substring(3, 7)) > 1822) &&
//            (Integer.parseInt(referencia.substring(3, 7)) < 9999)){
//            return true;
//        }
//        return false;
//    }
//    public static String converteReferenciaVencimento(String referencia, String diaVencimento, String tipo){
//        String vencimento = Data.data();
//        Data data = new Data();
//        if ((data.integridadeReferencia(referencia)) &&
//            (tipo.length() == 1)){
//            if (diaVencimento.length() == 1){
//                diaVencimento = "0" + diaVencimento;
//            }
//            int[] dataI = Data.dataToArrayInt(data.incrementarMeses(1, diaVencimento + "/" + referencia));
//            if ( Integer.parseInt(diaVencimento) < Data.dataToArrayInt(vencimento)[0]){
//                vencimento = vencimento.substring(0, 2) + "/" + referencia;
//            }else if (qtdeDiasDoMes(dataI[1], dataI[2]) >= Integer.parseInt(diaVencimento)) {
//                vencimento = diaVencimento + "/" + referencia;
//            }else{
//                vencimento = qtdeDiasDoMes(dataI[1], dataI[2]) + "/" + referencia;
//            }
//            if(tipo.equals("E")){
//                vencimento = data.incrementarMeses(1, vencimento);
//            }
//
//        }
//        return vencimento;
//    }
    public String incrementarMeses(int qtd, String data) {
        try {
            int tmp = 0;
            int c = 0;
            int[] d = Data.dataToArrayInt(data);
            if ((d[1] + qtd) > 12) {
                tmp = (d[1] + qtd);
                while (tmp > 12) {
                    tmp -= 12;
                    c++;
                }
                d[2] += c;
                d[1] = tmp;
            } else {
                d[1] += qtd;
            }

            if (d[0] > qtdeDiasDoMes(d[1], d[2])) {
                d[0] = qtdeDiasDoMes(d[1], d[2]);
            }

            return mascararData(d[0] + "/" + d[1] + "/" + d[2]);
        } catch (Exception e) {
            return null;
        }
    }

    public String decrementarMeses(int qtd, String data) {
        try {
            int tmp = 0;
            int c = 0;
            int[] d = Data.dataToArrayInt(data);
            if ((d[1] - qtd) < 1) {
                tmp = (d[1] - qtd);
                while (tmp < 1) {
                    tmp += 12;
                    c++;
                }
                d[2] -= c;
                d[1] = tmp;
            } else {
                d[1] -= qtd;
            }

            if (d[0] > qtdeDiasDoMes(d[1], d[2])) {
                d[0] = qtdeDiasDoMes(d[1], d[2]);
            }

            return mascararData(d[0] + "/" + d[1] + "/" + d[2]);
        } catch (Exception e) {
            return null;
        }
    }

    public String decrementarSemanas(int qtd, String data) {
        try {
            int tmp = 0;
            int[] d = Data.dataToArrayInt(data);
            int[] mesA = dataToArrayInt(decrementarMeses(1, data));
            int diasMesA = qtdeDiasDoMes(mesA[1], mesA[2]);
            if ((d[0] - (qtd * 7)) < 1) {
                tmp = (qtd * 7);
                diasMesA += d[0];
                tmp = diasMesA - tmp;
                d[1]--;
                if (d[1] < 1) {
                    d[1] = 12;
                    d[2]--;
                }
                diasMesA = qtdeDiasDoMes(mesA[1], mesA[2]);
                while (tmp > diasMesA) {
                    tmp = diasMesA - tmp;
                    d[1]--;
                    if (d[1] < 1) {
                        d[1] = 12;
                        d[2]--;
                    }
                    diasMesA = qtdeDiasDoMes(mesA[1], mesA[2]);
                }
                d[0] = tmp;
            } else {
                d[0] -= (qtd * 7);
            }

            return mascararData(d[0] + "/" + d[1] + "/" + d[2]);
        } catch (Exception e) {
            return null;
        }
    }

    public String incrementarSemanas(int qtd, String data) {
        try {
            int tmp = 0;
            int[] d = Data.dataToArrayInt(data);
            int dias = qtdeDiasDoMes(d[1], d[2]);

            if ((d[0] + (qtd * 7)) > dias) {
                tmp = (qtd * 7) + d[0];
                while (tmp >= dias) {
                    tmp -= dias;
                    d[1]++;
                    if (d[1] > 12) {
                        d[1] = 1;
                        d[2]++;
                    }
                    dias = qtdeDiasDoMes(d[1], d[2]);
                }
                d[0] = tmp;
            } else {
                d[0] += (qtd * 7);
            }

            return mascararData(d[0] + "/" + d[1] + "/" + d[2]);
        } catch (Exception e) {
            return null;
        }
    }

    public String incrementarDias(int qtd, String data) {
        try {
            int[] d = Data.dataToArrayInt(data);
            int dias = qtdeDiasDoMes(d[1], d[2]);
            if (qtd > dias) {
                while (qtd >= dias) {
                    qtd -= dias;
                    d[1]++;
                    if (d[1] > 12) {
                        d[1] = 1;
                        d[2]++;
                    }
                    dias = qtdeDiasDoMes(d[1], d[2]);
                }
                d[0] += qtd;
            } else {
                d[0] += qtd;
            }

            return mascararData(d[0] + "/" + d[1] + "/" + d[2]);
        } catch (Exception e) {
            return null;
        }
    }
//    
//    public String decrementarDias(int qtd, String data){
//        try{
//            int[] d = Data.dataToArrayInt(data);
//            int dias = qtdeDiasDoMes(d[1], d[2]);
//            if (qtd > dias){
//                while (qtd >= dias){
//                    qtd -= dias;
//                    d[1]++;
//                    if (d[1] > 12){
//                        d[1] = 1;
//                        d[2]++;
//                    }
//                    dias = qtdeDiasDoMes(d[1], d[2]);
//                }
//                d[0] += qtd;
//            }else{
//                d[0] += qtd;
//            }
//
//            return mascararData(d[0] + "/" + d[1] + "/" + d[2]);
//        }catch(Exception e){
//            return null;
//        }
//    }

    public String incrementarAnos(int qtd, String data) {
        try {
            if (qtd <= 0) {
                qtd = 1;
            }
            int[] d = Data.dataToArrayInt(data);
            d[2] = d[2] + qtd;
            if ((d[1] == 2) && ((d[0] == 28) || (d[0] == 29))) {
                if (isBisexto(d[2])) {
                    d[0] = 29;
                } else {
                    d[0] = 28;
                }
            }
            return mascararData(d[0] + "/" + d[1] + "/" + d[2]);
        } catch (Exception e) {
            return null;
        }
    }

    public String incrementarMesesUltimoDia(int qtd, String data) {
        try {
            int tmp = 0;
            int c = 0;
            int[] d = Data.dataToArrayInt("32/" + data.substring(3, 10));
            if ((d[1] + qtd) > 12) {
                tmp = (d[1] + qtd);
                while (tmp > 12) {
                    tmp -= 12;
                    c++;
                }
                d[2] += c;
                d[1] = tmp;
            } else {
                d[1] += qtd;
            }

            if (d[0] > qtdeDiasDoMes(d[1], d[2])) {
                d[0] = qtdeDiasDoMes(d[1], d[2]);
            }

            return mascararData(d[0] + "/" + d[1] + "/" + d[2]);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean menorData(String menor, String data) {
        String[] d1 = dataToArrayString(menor);
        String[] d2 = dataToArrayString(data);
        if (Integer.parseInt(d1[2] + d1[1] + d1[0]) < Integer.parseInt(d2[2] + d2[1] + d2[0])) {
            return true;
        }
        return false;
    }

    public boolean maiorData(String maior, String data) {
        String[] d1 = dataToArrayString(maior);
        String[] d2 = dataToArrayString(data);
        if (Integer.parseInt(d1[2] + d1[1] + d1[0]) > Integer.parseInt(d2[2] + d2[1] + d2[0])) {
            return true;
        }
        return false;
    }

    public boolean igualdadeData(String data1, String data2) {
        String[] d1 = dataToArrayString(data1);
        String[] d2 = dataToArrayString(data2);
        if (Integer.parseInt(d1[2] + d1[1] + d1[0]) == Integer.parseInt(d2[2] + d2[1] + d2[0])) {
            return true;
        }
        return false;
    }

    public String mascararData(String data) {
        return Data.converteData(Data.converte(data));
    }

    /**
     * Retorna a hora atual
     * @return hora atual
     */
    public static String hora() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar d = new GregorianCalendar();
        String hora = Integer.toString(d.get(GregorianCalendar.HOUR_OF_DAY)), minuto = Integer.toString(d.get(GregorianCalendar.MINUTE)), segundo = Integer.toString(d.get(GregorianCalendar.SECOND));
        if (hora.length() == 1) {
            sb.append("0").append(hora);
        } else {
            sb.append(hora);
        }

        sb.append(":");

        if (minuto.length() == 1) {
            sb.append("0").append(minuto);
        } else {
            sb.append(minuto);
        }

        sb.append(":");

        if (segundo.length() == 1) {
            sb.append("0").append(segundo);
        } else {
            sb.append(segundo);
        }

        return sb.toString();
    }

    public static String horaSemPonto() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar d = new GregorianCalendar();
        sb.append(d.get(GregorianCalendar.HOUR_OF_DAY));
        sb.append(d.get(GregorianCalendar.MINUTE));
        sb.append(d.get(GregorianCalendar.SECOND));

        return sb.toString();
    }

    public static String horaMinuto() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar d = new GregorianCalendar();
        if (d.get(GregorianCalendar.HOUR_OF_DAY) < 9) {
            sb.append("0").append(d.get(GregorianCalendar.HOUR_OF_DAY));
        } else {
            sb.append(d.get(GregorianCalendar.HOUR_OF_DAY));
        }
        sb.append(":");
        if (d.get(GregorianCalendar.MINUTE) < 9) {
            sb.append("0").append(d.get(GregorianCalendar.MINUTE));
        } else {
            sb.append(d.get(GregorianCalendar.MINUTE));
        }
        return sb.toString();
    }

    public static String colocarBarras(String data) {
        return data.substring(0, 2) + "/"
                + data.substring(2, 4) + "/"
                + data.substring(4, 8);
    }

    public static int converteDataParaInteger(String data) {
        return Integer.parseInt(Data.dataToArrayString(data)[2]
                + Data.dataToArrayString(data)[1]
                + Data.dataToArrayString(data)[0]);
    }

    public static int converteDataParaRefInteger(String data) {
        return Integer.parseInt(Data.dataToArrayString(data)[2]
                + Data.dataToArrayString(data)[1]);
    }

    public boolean faixaCincoAnos(String data) {
        int dataHoje = Data.converteDataParaRefInteger(Data.data());
        int dataAntes = Data.converteDataParaRefInteger(decrementarMeses(60, Data.data()));
        int dataM = Data.converteDataParaRefInteger(data);

        if ((dataM > dataAntes)
                && (dataM <= dataHoje)) {
            return true;
        } else {
            return false;
        }
    }

    public int calcularIdade(String dataNascimento) {
        int idade = -1;
        String dataHoje = Data.data();
        int[] dataH = Data.dataToArrayInt(dataHoje);
        int[] dataN = Data.dataToArrayInt(dataNascimento);
        idade = dataN[2] - dataH[2];
        int[] novaData = Data.dataToArrayInt(incrementarAnos(idade, dataNascimento));
        if (dataH[1] < novaData[1]) {
            idade--;
        } else if (dataH[1] == novaData[1]) {
            if (dataH[0] < dataH[0]) {
                idade--;
            }
        }
        return idade;
    }

    public int calcularIdade(Date data) {
        String dataNascimento = Data.converteData(data);
        int idade = -1;
        String dataHoje = Data.data();
        int[] dataH = Data.dataToArrayInt(dataHoje);
        int[] dataN = Data.dataToArrayInt(dataNascimento);
        idade = dataH[2] - dataN[2];
        int[] novaData = Data.dataToArrayInt(incrementarAnos(idade, dataNascimento));
        if (dataH[1] < novaData[1]) {
            idade--;
        } else if (dataH[1] == novaData[1]) {
            if (dataH[0] < dataH[0]) {
                idade--;
            }
        }
        return idade;
    }

    public static String validaHora(String hora) {
        int n1 = 0;
        int n2 = 0;
        if (hora.length() == 1) {
            hora = "0" + hora + ":00";
        }

        if (hora.length() == 2) {
            if ((Integer.parseInt(hora) >= 0) && (Integer.parseInt(hora) <= 23)) {
                hora = hora + ":00";
            } else {
                hora = "";
            }
        } else if (hora.length() == 3) {
            n1 = Integer.parseInt(hora.substring(0, 2));
            String pontos = hora.substring(2, 3);

            if (((n1 >= 0) && (n1 <= 23)) && pontos.equals(":")) {
                hora = hora + "00";
            } else {
                hora = "";
            }
        } else if (hora.length() == 4) {
            n1 = Integer.parseInt(hora.substring(0, 2));
            n2 = Integer.parseInt(hora.substring(3, 4));
            String pontos = hora.substring(2, 3);

            if ((pontos.equals(":")) && ((n1 >= 0) && (n1 <= 23)) && ((n2 >= 0) && (n2 <= 5))) {
                hora = hora + "0";
            } else {
                hora = "";
            }
        } else if (hora.length() == 5) {
            n1 = Integer.parseInt(hora.substring(0, 2));
            n2 = Integer.parseInt(hora.substring(3, 5));
            String pontos = hora.substring(2, 3);

            if (!(((n1 >= 0) && (n1 <= 23)) && ((n2 >= 0) && (n2 <= 59)) && (pontos.equals(":")))) {
                hora = "";
            }
        }
        return hora;
    }

    /**
     * Converte data para data por extenso
     * @param data
     * @return data por extenso
     */
    public static String dataExtenso(String data) {
        String extenso = "";
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, 10);

        if (dia.equals("01")) {
            dia = "Primeiro";
        }
        if (dia.equals("02")) {
            dia = "Dois";
        }
        if (dia.equals("03")) {
            dia = "Três";
        }
        if (dia.equals("04")) {
            dia = "Quatro";
        }
        if (dia.equals("05")) {
            dia = "Cinco";
        }
        if (dia.equals("06")) {
            dia = "Seis";
        }
        if (dia.equals("07")) {
            dia = "Sete";
        }
        if (dia.equals("08")) {
            dia = "Oito";
        }
        if (dia.equals("09")) {
            dia = "Nove";
        }
        if (dia.equals("10")) {
            dia = "Dez";
        }
        if (dia.equals("11")) {
            dia = "Onze";
        }
        if (dia.equals("12")) {
            dia = "Doze";
        }
        if (dia.equals("13")) {
            dia = "Treze";
        }
        if (dia.equals("14")) {
            dia = "Quatorze";
        }
        if (dia.equals("15")) {
            dia = "Quinhe";
        }
        if (dia.equals("16")) {
            dia = "Dezesseis";
        }
        if (dia.equals("17")) {
            dia = "Dezessete";
        }
        if (dia.equals("18")) {
            dia = "Dezoito";
        }
        if (dia.equals("19")) {
            dia = "Dezenove";
        }
        if (dia.equals("20")) {
            dia = "Vinte";
        }
        if (dia.equals("21")) {
            dia = "Vinte e Um";
        }
        if (dia.equals("22")) {
            dia = "Vinte e Dois";
        }
        if (dia.equals("23")) {
            dia = "Vinte e Três";
        }
        if (dia.equals("24")) {
            dia = "Vinte e Quatro";
        }
        if (dia.equals("25")) {
            dia = "Vinte e Cinco";
        }
        if (dia.equals("26")) {
            dia = "Vinte e Seis";
        }
        if (dia.equals("27")) {
            dia = "Vinte e Sete";
        }
        if (dia.equals("28")) {
            dia = "Vinte e Oito";
        }
        if (dia.equals("29")) {
            dia = "Vinte e Nove";
        }
        if (dia.equals("30")) {
            dia = "Trinta";
        }
        if (dia.equals("31")) {
            dia = "Trinta e Um";
        }

        if (mes.equals("01")) {
            mes = "Janeiro";
        }
        if (mes.equals("02")) {
            mes = "Fevereiro";
        }
        if (mes.equals("03")) {
            mes = "Março";
        }
        if (mes.equals("04")) {
            mes = "Abril";
        }
        if (mes.equals("05")) {
            mes = "Maio";
        }
        if (mes.equals("06")) {
            mes = "Junho";
        }
        if (mes.equals("07")) {
            mes = "Julho";
        }
        if (mes.equals("08")) {
            mes = "Agosto";
        }
        if (mes.equals("09")) {
            mes = "Setembro";
        }
        if (mes.equals("10")) {
            mes = "Outubro";
        }
        if (mes.equals("11")) {
            mes = "Novembro";
        }
        if (mes.equals("12")) {
            mes = "Dezembro";
        }

        extenso = dia + " de " + mes + " de " + ano;
        return extenso;

    }

}
