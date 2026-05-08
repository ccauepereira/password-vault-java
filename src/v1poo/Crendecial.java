package v1poo;

public class Crendecial {
    private String site;
    private String usuario;
    private String senha;
    private int id;
    private int forca;
    public static int idAux = 1;

    public Crendecial(String site,String usuario,String senha){
        this.site = site;
        this.usuario = usuario;
        this.senha = senha;
        this.id = idAux++;
        this.forca = calcularForca(senha);
    }

    public Crendecial(String site){
        this(site,"","");
    }
    private int calcularForca(String senha) {
        int forca = 0;
        
        if (senha.length() >= 8) {
            forca += 25;
        }
        
        for (int i = 0; i < senha.length(); i++) {
            char letra = senha.charAt(i);
            if (Character.isUpperCase(letra)) {
                forca += 25;
                break;
            }
        }
        
        for (int i = 0; i < senha.length(); i++) {
            char num = senha.charAt(i);
            if (Character.isDigit(num)) {
                forca += 25;
                break;
            }
        }
        
        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            String esp = "@!%&*$#";
            if (esp.indexOf(c) != -1) {
                forca += 25;
                break;
            }
        }
        return forca;
    }
    
    public void setSite(String site){
        this.site = site;
    }
    public String getSite(){
        return this.site;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return this.senha;
    }
    public int getId(){
        return this.id;
    }
    public int getForca(){
        return this.forca;
    }
    public static int getProximoId(){
        return idAux;
    }
    @Override
    public String toString(){
        String r;
        r = "[" + id + "] "+site+" | "+usuario+" | Força: "+forca;
        return r;
    }

}
