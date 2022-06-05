/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage Flo2.jpeg
 *
 *  @author:
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) {

	    this.collageDimension = 4;
        this.tileDimension = 100;
        this.original = new Picture(filename);
        this.collage = new Picture(tileDimension*collageDimension, tileDimension*collageDimension);
        int checker = tileDimension*collageDimension;
        for (int ti = 0; ti < checker; ti++){
            for (int tj = 0; tj < checker; tj++){
                int si = ti * original.width() / checker;
                int sj = tj * original.height() / checker;
                Color color = original.get(si, sj);
                collage.set(ti, tj, color);
            }
        }

    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) {

	    this.collageDimension = cd;
        this.tileDimension = td;
        this.original = new Picture(filename);
        this.collage = new Picture(tileDimension*collageDimension, tileDimension*collageDimension);
        int checker = tileDimension*collageDimension;
        for (int ti = 0; ti < checker; ti++){
            for (int tj = 0; tj < checker; tj++){
                int si = ti * original.width() / checker;
                int sj = tj * original.height() / checker;
                Color color = original.get(si, sj);
                collage.set(ti, tj, color);
            }
        }

    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() {

	    return collageDimension;
    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() {

	    return tileDimension;
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() {

	    return original;
    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() {

	    return collage;
    }
    
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() {

        original = getOriginalPicture();
	    original.show();
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() {

        collage = getCollagePicture();
	    collage.show();
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) {

        Picture replace = new Picture(filename);
        Picture replace1 = new Picture(tileDimension, tileDimension);
        int checker = tileDimension;
        for (int ti = 0; ti < checker; ti++){
            for (int tj = 0; tj < checker; tj++){
                int si = ti * replace.width() / checker;
                int sj = tj * replace.height() / checker;
                Color color = replace.get(si, sj);
                replace1.set(ti, tj, color);
            }
        }

        for(int col = 0; col < checker; col++){ //these two for loops are iterating over the tiles of the collage
            for(int row = 0; row < checker; row++){
                Color color = replace1.get(col, row);
                for(int i = collageRow; i < collageRow+1; i++){ //these two for loops are iterating over each pixel in the tiles of the collage
                    for(int j = collageCol; j < collageCol+1; j++){
                        collage.set(tileDimension * j + col, tileDimension * i + row, color);
                        
                    }
                }
            }
        }
    }
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
    public void makeCollage () {

        int checker = tileDimension;
        Picture midPicture = new Picture(checker, checker);

        for (int ti = 0; ti < checker; ti++){ //this code resizes the whole picture/image
            for (int tj = 0; tj < checker; tj++){
                int si = ti * collage.width() / checker;
                int sj = tj * collage.height() / checker;
                Color color = collage.get(si, sj);
                midPicture.set(ti, tj, color);
            }
        }

        for(int col = 0; col < checker; col++){ //these two for loops are iterating over the tiles of the collage
            for(int row = 0; row < checker; row++){
                Color color = midPicture.get(col, row);
                for(int i = 0; i < collageDimension; i++){ //these two for loops are iterating over each pixel in the tiles of the collage
                    for(int j = 0; j < collageDimension; j++){
                        collage.set(tileDimension * j + col, tileDimension * i + row, color);
                        
                    }
                }
            }
        }
        

    }

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see CS111 Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) {

        int checker = tileDimension;

        if(component == "red"){
            for(int col = 0; col < checker; col++){ //these two for loops are iterating over the tiles of the collage
                for(int row = 0; row < checker; row++){
                    for(int i = collageRow; i < collageRow+1; i++){ //these two for loops are iterating over each pixel in the tiles of the collage
                        for(int j = collageCol; j < collageCol+1; j++){
                            Color color = collage.get(tileDimension * j + col, tileDimension * i + row);
                            int r = color.getRed();
                            Color red = new Color(r,0,0);
                            collage.set(tileDimension * j + col, tileDimension * i + row, red);             
                        }
                    }
                }
            }
        }else if(component == "blue"){
            for(int col = 0; col < checker; col++){ //these two for loops are iterating over the tiles of the collage
                for(int row = 0; row < checker; row++){
                    for(int i = collageRow; i < collageRow+1; i++){ //these two for loops are iterating over each pixel in the tiles of the collage
                        for(int j = collageCol; j < collageCol+1; j++){
                            Color color = collage.get(tileDimension * j + col, tileDimension * i + row);
                            int b = color.getBlue();
                            Color blue = new Color(0,0,b);
                            collage.set(tileDimension * j + col, tileDimension * i + row, blue);             
                        }
                    }
                }
            }
        }else{
            for(int col = 0; col < checker; col++){ //these two for loops are iterating over the tiles of the collage
                for(int row = 0; row < checker; row++){
                    for(int i = collageRow; i < collageRow+1; i++){ //these two for loops are iterating over each pixel in the tiles of the collage
                        for(int j = collageCol; j < collageCol+1; j++){
                            Color color = collage.get(tileDimension * j + col, tileDimension * i + row);
                            int g = color.getGreen();
                            Color green = new Color(0,g,0);
                            collage.set(tileDimension * j + col, tileDimension * i + row, green);             
                        }
                    }
                }
            }
        }
        
        
    }

    /*
     * Grayscale tile at (collageCol, collageRow)
     * (see CS111 Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */

    public void grayscaleTile (int collageCol, int collageRow) {

	    int checker = tileDimension;

        for(int col = 0; col < checker; col++){ //these two for loops are iterating over the tiles of the collage
            for(int row = 0; row < checker; row++){
                for(int i = collageRow; i < collageRow+1; i++){ //these two for loops are iterating over each pixel in the tiles of the collage
                    for(int j = collageCol; j < collageCol+1; j++){
                        Color color = collage.get(tileDimension * j + col, tileDimension * i + row);
                        Color gray = Luminance.toGray(color);
                        collage.set(tileDimension * j + col, tileDimension * i + row, gray);             
                    }
                }
            }
        }

    }


    /*
     *
     *  Test client: use the examples given on the assignment description to test your ArtCollage
     */
    public static void main (String[] args) {

        ArtCollage art = new ArtCollage(args[0]); 
        art.showCollagePicture();
    }
}
