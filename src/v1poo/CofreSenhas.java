package v1poo;

public class CofreSenhas {
    private String senhaMestra;
    private int total;
    private boolean desbloqueado;
    private Crendecial[] crendecials;

    public CofreSenhas(String senhaMestra) {
        this.crendecials = new Crendecial[100];
        this.senhaMestra = senhaMestra;
        this.total = 0;
        this.desbloqueado = false;
    }

    public boolean desbloquear(String senha) {
        if (senha.equals(senhaMestra)) {
            desbloqueado = true;
            return true;
        }
        return false;
    }

    public void adicionar(Crendecial c) {
        if (!desbloqueado) {
            System.out.println("Cofre Bloqueado!");
            return;
        }
        if (total >= 100) {
            System.out.println("Cofre Cheio!");
            return;
        }
        crendecials[total] = c;
        total++;
    }

    public void listar() {
        for (int i = 0; i < total; i++) {
            System.out.println(crendecials[i]);
        }
    }

    public void ordenarPorSite() {
        Crendecial aux;
        for (int i = 0; i < total - 1; i++) {
            for (int j = i + 1; j < total; j++) {
                if (crendecials[i].getSite()
                        .compareTo(crendecials[j].getSite()) > 0) {
                    aux = crendecials[i];
                    crendecials[i] = crendecials[j];
                    crendecials[j] = aux;
                }
            }
        }
    }

    public void ordenarPorForca() {
        Crendecial aux;
        for (int i = 0; i < total - 1; i++) {
            for (int j = i + 1; j < total; j++) {
                if (crendecials[i].getForca()
                        < crendecials[j].getForca()) {
                    aux = crendecials[i];
                    crendecials[i] = crendecials[j];
                    crendecials[j] = aux;
                }
            }
        }
    }

    public Crendecial maisFraca() {
        Crendecial fraca = crendecials[0];
        for (int i = 1; i < total; i++) {
            if (crendecials[i].getForca() < fraca.getForca()) {
                fraca = crendecials[i];
            }
        }
        return fraca;
    }

    public int contarFracas() {
        int cont = 0;
        for (int i = 0; i < total; i++) {
            if (crendecials[i].getForca() < 50) {
                cont++;
            }
        }
        return cont;
    }
    public boolean isDesbloqueado() {
        return desbloqueado;
    }

    public int getTotal() {
        return total;
    }

    public Crendecial buscarPorSite(String site) {
        for (int i = 0; i < total; i++) {
            if (crendecials[i].getSite().equalsIgnoreCase(site)) {
                return crendecials[i];
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "\nCofre: " + total +
                " credenciais | Desbloqueado: " +
                desbloqueado;
    }
}