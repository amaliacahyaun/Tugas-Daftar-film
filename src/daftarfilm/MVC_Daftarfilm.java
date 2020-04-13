/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daftarfilm;

/**
 *
 * @author DELL
 */
public class MVC_Daftarfilm {
     ViewDaftarfilm viewDaftarfilm = new ViewDaftarfilm();
    ModelDaftarfilm modelDaftarfilm = new ModelDaftarfilm();
    ControllerDaftarfilm controllerDaftarfilm = new ControllerDaftarfilm(modelDaftarfilm, viewDaftarfilm);
}
