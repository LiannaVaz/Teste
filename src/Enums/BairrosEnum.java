package Enums;

public enum BairrosEnum {
        AdhemarGarcia("Adhemar Garcia"),
        América("América"),
        AnitaGaribaldi("Anita Garibaldi"),
        Atiradores("Atiradores"),
        Aventureiro("Aventureiro"),
        BoaVista("Boa Vista"),
        Boehmerwald("Boehmerwald"),
        BomRetiro("Bom Retiro"),
        Bucarein("Bucarein"),
        Centro("Centro"),
        Comasa("Comasa"),
        CostaESilva("Costa e Silva"),
        Espinheiros("Espinheiros"),
        Fátima("Fátima"),
        Floresta("Floresta"),
        Glória("Glória"),
        Guanabara("Guanabara"),
        Iririú("Iririú"),
        Itaum("Itaum"),
        Itinga("Itinga"),
        ParqueGuarani("Parque Guarani"),
        JardimIririú("Jardim Iririú"),
        JardimParaíso("Jardim Paraíso"),
        JardimSophia("Jardim Sophia"),
        Jarivatuba("Jarivatuba"),
        JoãoCosta("João Costa"),
        MorroDoMeio("Morro do Meio"),
        NovaBrasília("Nova Brasília"),
        Paranaguamirim("Paranaguamirim"),
        Petrópolis("Petrópolis"),
        Pirabeiraba("Pirabeiraba"),
        Profipo("Profipo"),
        Saguaçu("Saguaçu"),
        SantaCatarina("Santa Catarina"),
        SantoAntônio("Santo Antônio"),
        SãoMarcos("São Marcos"),
        UlyssesGuimarães("Ulysses Guimarães"),
        VilaCubatão("Vila Cubatão"),
        VilaNova("Vila Nova"),
        ZonaIndustrialNorte("Zona Industrial Norte");
    
        private String descricao;

        BairrosEnum() {
        }        

        BairrosEnum(String nome) {
                this.descricao = nome;
        }

        public String getDescricao() {
                return this.descricao;
        }




}
