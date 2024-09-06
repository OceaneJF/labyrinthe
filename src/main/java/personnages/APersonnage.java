/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 *
 * @author ojfrancois
 */
public abstract class APersonnage implements IPersonnage {

    private ISalle position;

    public APersonnage(ISalle position) {
        this.position = position;
    }

    @Override
    public ISalle getPosition() {
        return position;
    }

    @Override
    public void setPosition(ISalle position) {
        this.position = position;
    }

}
