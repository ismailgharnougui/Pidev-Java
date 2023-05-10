package models;

public class Article {

    private int ArtId;
    private String ArtLib;
    private String ArtDesc;
    private int ArtDispo;
    private String ArtImg;
    private int ArtPrix;
    private String CatLib;
    private int CatId;
    private int UserId;

    public Article() {
    }
    

    /* public Article(int ArtId, String ArtLib, String ArtDesc, int ArtDispo, String ArtImg, int ArtPrix, String CatLib, int CatId, int UserId) {
        this.ArtId = ArtId;
        this.ArtLib = ArtLib;
        this.ArtDesc = ArtDesc;
        this.ArtDispo = ArtDispo;
        this.ArtImg = ArtImg;
        this.ArtPrix = ArtPrix;
        this.CatLib = CatLib;
        this.CatId = CatId;
        this.UserId = UserId;
    } 
    
     public Article(int ArtId, String ArtLib, String ArtDesc, int ArtDispo, String ArtImg, int ArtPrix, int UserId) {
        this.ArtId = ArtId;
        this.ArtLib = ArtLib;
        this.ArtDesc = ArtDesc;
        this.ArtDispo = ArtDispo;
        this.ArtImg = ArtImg;
        this.ArtPrix = ArtPrix;
        this.UserId = UserId;

    }
    
    public Article(int ArtId, String ArtLib, String ArtDesc, int ArtDispo, String ArtImg, int ArtPrix) {
        this.ArtId = ArtId;
        this.ArtLib = ArtLib;
        this.ArtDesc = ArtDesc;
        this.ArtDispo = ArtDispo;
        this.ArtImg = ArtImg;
        this.ArtPrix = ArtPrix;
    }

    public Article(int ArtId, String ArtLib, String ArtDesc, int ArtDispo, String ArtImg, int ArtPrix, String CatLib) {
        this.ArtId = ArtId;
        this.ArtLib = ArtLib;
        this.ArtDesc = ArtDesc;
        this.ArtDispo = ArtDispo;
        this.ArtImg = ArtImg;
        this.ArtPrix = ArtPrix;
        this.CatLib = CatLib;
    }
    

    public Article(String ArtLib, String ArtDesc, int ArtDispo, String ArtImg, int ArtPrix) {
        this.ArtLib = ArtLib;
        this.ArtDesc = ArtDesc;
        this.ArtDispo = ArtDispo;
        this.ArtImg = ArtImg;
        this.ArtPrix = ArtPrix;
    }
    
      public Article(String ArtLib, String ArtDesc, int ArtDispo, String ArtImg, int ArtPrix,String catLib) {
        this.ArtLib = ArtLib;
        this.ArtDesc = ArtDesc;
        this.ArtDispo = ArtDispo;
        this.ArtImg = ArtImg;
        this.ArtPrix = ArtPrix;
        this.CatLib = catLib;
    }
    
    
    

    public Article(String ArtLib, String ArtDesc, int ArtDispo, String ArtImg, int ArtPrix, String ArtVille, int CatId) {
        this.ArtLib = ArtLib;
        this.ArtDesc = ArtDesc;
        this.ArtDispo = ArtDispo;
        this.ArtImg = ArtImg;
        this.ArtPrix = ArtPrix;
        this.CatId = CatId;
    }

    public Article(String ArtLib, String ArtDesc) {
        this.ArtLib = ArtLib;
        this.ArtDesc = ArtDesc;
    }
    */

    public Article(String ArtLib, String ArtDesc, int ArtDispo, String ArtImg, int ArtPrix, String CatLib, int UserId) {
        this.ArtLib = ArtLib;
        this.ArtDesc = ArtDesc;
        this.ArtDispo = ArtDispo;
        this.ArtImg = ArtImg;
        this.ArtPrix = ArtPrix;
        this.CatLib = CatLib;
        this.UserId = UserId;
    }
            
    public Article(int ArtId, String ArtLib, String ArtDesc, int ArtDispo, String ArtImg, int ArtPrix, String CatLib, int UserId) {
        this.ArtId = ArtId;
        this.ArtLib = ArtLib;
        this.ArtDesc = ArtDesc;
        this.ArtDispo = ArtDispo;
        this.ArtImg = ArtImg;
        this.ArtPrix = ArtPrix;
        this.CatLib = CatLib;
        this.UserId = UserId;
    }
public int getArtId() {
        return ArtId;
    }

    public void setArtId(int ArtId) {
        this.ArtId = ArtId;
    }

    public String getArtLib() {
        return ArtLib;
    }

    public void setArtLib(String ArtLib) {
        this.ArtLib = ArtLib;
    }

    public String getArtDesc() {
        return ArtDesc;
    }

    public void setArtDesc(String ArtDesc) {
        this.ArtDesc = ArtDesc;
    }

    public int getArtDispo() {
        return ArtDispo;
    }

    public void setArtDispo(int ArtDispo) {
        this.ArtDispo = ArtDispo;
    }

    public String getArtImg() {
        return ArtImg;
    }

    public void setArtImg(String ArtImg) {
        this.ArtImg = ArtImg;
    }

    public int getArtPrix() {
        return ArtPrix;
    }

    public void setArtPrix(int ArtPrix) {
        this.ArtPrix = ArtPrix;
    }


 

    public String getCatLib() {
        return CatLib;
    }

    public void setCatLib(String CatLib) {
        this.CatLib = CatLib;
    }

    public int getCatId() {
        return CatId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setCatId(int CatId) {
        this.CatId = CatId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    
    
    

    @Override
    public String toString() {
        return "Article{" + "ArtId=" + ArtId + ",ArtLib=" + ArtLib + ", ArtDesc=" + ArtDesc + ", ArtDispo=" + ArtDispo + ", ArtImg=" + ArtImg + ", ArtPrix=" + ArtPrix + ", CatLib=" + CatLib + '}';
    }
}
