package id.blank15.tukangbakso;

/**
 * Created by joedhaalzelvin on 14/04/18.
 */

public class Menu {
    private String id;
    private String namaMenu;
    private String harga;

    public Menu() {
    }

    public Menu(String id, String namaMenu, String harga) {
        this.id = id;
        this.namaMenu = namaMenu;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
