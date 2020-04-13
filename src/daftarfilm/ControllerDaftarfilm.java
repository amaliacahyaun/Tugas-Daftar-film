/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daftarfilm;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerDaftarfilm {
    ModelDaftarfilm modelDaftarfilm;
    ViewDaftarfilm viewDaftarfilm;
    
    public ControllerDaftarfilm(ModelDaftarfilm modelDaftarfilm, ViewDaftarfilm viewDaftarfilm){
        this.modelDaftarfilm = modelDaftarfilm;
        this.viewDaftarfilm = viewDaftarfilm;
        if(modelDaftarfilm.getBanyakData() !=0){
           String dataFilm[][]= modelDaftarfilm.readFilm();
           viewDaftarfilm.tabel.setModel((new JTable(dataFilm, viewDaftarfilm.namaKolom)).getModel());
        }
        else{
            JOptionPane.showMessageDialog(null,"Data Tidak ada");          
        }
        viewDaftarfilm.btnCreatePanel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (viewDaftarfilm.getJudul().equals("")
                        || viewDaftarfilm.getTipe().equals("")
                        || viewDaftarfilm.getEpisode().equals("")
                        || viewDaftarfilm.getGenre().equals("")
                        || viewDaftarfilm.getStatus().equals("")
                        || viewDaftarfilm.getRating().equals("")){
                    JOptionPane.showMessageDialog(null, "Field tidk boleh kosong");
                       
            }else{
                    String judul = viewDaftarfilm.getJudul();
                    String tipe = viewDaftarfilm.getTipe();
                    String episode = viewDaftarfilm.getEpisode();
                    String genre = viewDaftarfilm.getGenre();
                    String status = viewDaftarfilm.getStatus();
                    String rating = viewDaftarfilm.getRating();
                    modelDaftarfilm.createFilm(/* id,*/judul, tipe, episode, genre, status,rating);
                    
                    String dataFilm[][] = modelDaftarfilm.readFilm();
                    viewDaftarfilm.tabel.setModel(new JTable (dataFilm, viewDaftarfilm.namaKolom).getModel());
                }
                
        }
        }); 
        
    viewDaftarfilm.btnRefershPanel.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String dataFilm[][] = modelDaftarfilm.readFilm();
                    viewDaftarfilm.tabel.setModel(new JTable (dataFilm, viewDaftarfilm.namaKolom).getModel());
                
            viewDaftarfilm.tfID.setText(null);
            viewDaftarfilm.tfJudul.setText(null);
            viewDaftarfilm.tfTipe.setText(null);
            viewDaftarfilm.tfEpisode.setText(null);
            viewDaftarfilm.tfGenre.setText(null);
            viewDaftarfilm.tfRating.setText(null);
            viewDaftarfilm.cmbStatus.setSelectedItem(this);
            viewDaftarfilm.tfSearch.setText(null);
        }
    });
        
    viewDaftarfilm.btnSearch.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
        String getSearch= viewDaftarfilm.getSearch();
                String dataFilm[][] = modelDaftarfilm.searchFilm(getSearch);
                    viewDaftarfilm.tabel.setModel(new JTable (dataFilm, viewDaftarfilm.namaKolom).getModel());
                 }
        }); 

                
    viewDaftarfilm.tabel.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
           int baris = viewDaftarfilm.tabel.getSelectedRow();
           int kolom = viewDaftarfilm.tabel.getSelectedColumn();
        String dataterpilih = viewDaftarfilm.tabel.getValueAt(baris, 0).toString();
        System.out.println(dataterpilih);
       
        String judul =viewDaftarfilm.tabel.getValueAt(baris, 1).toString();
        viewDaftarfilm.tfJudul.setText(judul);
        String tipe =viewDaftarfilm.tabel.getValueAt(baris, 2).toString();
        viewDaftarfilm.tfTipe.setText(tipe);
        String episode =viewDaftarfilm.tabel.getValueAt(baris, 3).toString();
        viewDaftarfilm.tfEpisode.setText(episode);
        String genre =viewDaftarfilm.tabel.getValueAt(baris, 4).toString();
        viewDaftarfilm.tfGenre.setText(genre);
        String status =viewDaftarfilm.tabel.getValueAt(baris, 5).toString();
        viewDaftarfilm.cmbStatus.setSelectedItem(status);
        String rating =viewDaftarfilm.tabel.getValueAt(baris, 6).toString();
        viewDaftarfilm.tfRating.setText(rating);        
        
        viewDaftarfilm.btnUpdatePanel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){ 
                 String id = dataterpilih;
                    
                    String judul = viewDaftarfilm.getJudul();
                    String tipe = viewDaftarfilm.getTipe();
                    String episode = viewDaftarfilm.getEpisode();
                    String genre = viewDaftarfilm.getGenre();
                    String status = viewDaftarfilm.getStatus();
                    String rating = viewDaftarfilm.getRating();
                    modelDaftarfilm.UpdateFilm( id,judul, tipe, episode, genre, status,rating);
                

                String dataFilm[][]= modelDaftarfilm.readFilm();
                viewDaftarfilm.tabel.setModel(new JTable(dataFilm, viewDaftarfilm.namaKolom).getModel());

     }
        });
        
       viewDaftarfilm.btnDeletePanel.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){    
                    modelDaftarfilm.deleteFilm(dataterpilih);
                    String dataFilm[][]= modelDaftarfilm.readFilm();
                    viewDaftarfilm.tabel.setModel(new JTable(dataFilm, viewDaftarfilm.namaKolom).getModel());
                  
             }
        });
    
     }
       });
   
   
    }
}