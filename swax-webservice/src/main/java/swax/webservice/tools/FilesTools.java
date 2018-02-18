package swax.webservice.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import swax.webservice.entity.album.AlbumDiscogs;
import swax.webservice.entity.album.AlbumDiscogsWantlist;

/**
 * 
 * @author Matthieu Ibarra
 * Methods to upload files
 *
 */

public class FilesTools {
	
//	TODO Add controls on the file uploaded (type, variables...)
//	TODO check out how to limit the size (client validation ?)
	
	static final long IMG_MAX_SIZE = 3145728;
	
	public static void uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
		
        byte[] bytes = file.getBytes();
        Path path = Paths.get(request.getSession().getServletContext().
        		getRealPath("files/"+file.getOriginalFilename()));
        Files.write(path, bytes);
	}
	
	public static String uploadImg(MultipartFile file, String imgFileName, HttpServletRequest request) throws IOException, InterruptedException {
        
		String filePath = request.getSession().getServletContext().getRealPath("img/swapAlbums/"+imgFileName+".jpg");
        byte[] bytes = file.getBytes();
        String errMsg = "";
        
        if (file.isEmpty()) {
        	errMsg = "No image";
        	return errMsg;
        } else if (!file.getContentType().equals("image/jpeg")) {
        	errMsg = "Please try to upload a JPEG/JPG image";
        	return errMsg;
        } else if (file.getSize() > IMG_MAX_SIZE) {
        	errMsg = "The file's size must be < 3M";
        	return errMsg;        	
        }
                
        if (!file.isEmpty()) {
        	Path path = Paths.get(filePath);
        	Files.write(path, bytes);
        	
//    		ExecutorService service = Executors.newFixedThreadPool(10);
//    		Future<String> future = service.submit(new Callable<String>() {				
//				public String call() {
//					System.out.println("debut tache " + Thread.currentThread().getName());
//					try {
//						Files.write(path, bytes);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					String errMsg = "ImgWritten";
//					System.out.println("Fin tache: "+errMsg+" "+Thread.currentThread().getName());
//					return errMsg;
//				}
//			});
//    		service.shutdown();
//    		service.awaitTermination(1, TimeUnit.HOURS);
        	
    		BufferedImage originalImage = ImageIO.read(new File(filePath));
    		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
    		
			BufferedImage resizeImageHintPng = ImgTools.resizeImageWithHint(originalImage, type);
			ImageIO.write(resizeImageHintPng, "png", new File(filePath));
        }
        else errMsg = "The file you uploaded is empty";
        
        return errMsg;
        
	}
	
	public static void deleteFile(String filePath) {
		File fileToDelete = new File(filePath);
        fileToDelete.delete();
	}
	
	public static void renameFile(String filePath, String fileName) {
		File fileToRename = new File(filePath);
		File newNamedFile = new File(fileName);
        fileToRename.renameTo(newNamedFile);
	}

	public static List<AlbumDiscogs> importCollectionCSVFile(String filePath) throws IOException {

		List<AlbumDiscogs> albumsDiscogs = new ArrayList<AlbumDiscogs>();

		BufferedReader br;
		br = new BufferedReader(new FileReader(new File(filePath)));

		String line;

		while ((line = br.readLine()) != null) {
			line = line.replace(", ", "; ");
			line = line.replace(",", ", ");
			System.out.println(line);
			String[] entries = line.split(",");
			List<String> var = new ArrayList<>();
			
			int i = 0;
			for (String entry: entries) {
				var.add(entry.trim());
				if (var.get(i).startsWith("\"") || var.get(i).endsWith("\"")) {
					String trimVar = var.get(i);
					var.remove(i);					
					var.add(i, trimVar.substring(1, trimVar.length()-1));
				}
				i++;
			}
			AlbumDiscogs albumDiscogsWantlist = new AlbumDiscogs(null,var.get(0), var.get(1), var.get(2), var.get(3), 
					var.get(4), var.get(5), var.get(6), var.get(7), var.get(8), var.get(9), var.get(10),
					var.get(11), var.get(12));
			albumsDiscogs.add(albumDiscogsWantlist);
		}

		br.close();
		
		deleteFile(filePath);
		
		return albumsDiscogs;
	}

	public static List<AlbumDiscogsWantlist> importWantlistCSVFile(String filePath) throws IOException {

		List<AlbumDiscogsWantlist> albumsDiscogsWantlist = new ArrayList<AlbumDiscogsWantlist>();

		BufferedReader br;
		br = new BufferedReader(new FileReader(new File(filePath)));

		String line;

		while ((line = br.readLine()) != null) {
			line = line.replace(",\",", ",");
			line = line.replace(", ", "; ");
			line = line.replace(",", ", ");
			
			System.out.println(line);
			String[] entries = line.split(",");
			List<String> var = new ArrayList<>();
			
			int i = 0;
			for (String entry: entries) {
				var.add(entry.trim());
				if (var.get(i).startsWith("\"") || var.get(i).endsWith("\"") && (var.get(i).length()>=2)) {
					String trimVar = var.get(i);
					var.remove(i);
//					System.out.println(trimVar+"\n");
					var.add(i, trimVar.substring(1, trimVar.length()-1));
				}
				i++;
			}
			AlbumDiscogsWantlist albumDiscogsWantlist = new AlbumDiscogsWantlist(var.get(0), var.get(1), var.get(2), var.get(3), 
					var.get(4), var.get(5), var.get(6), var.get(7), var.get(8), var.get(9));
			albumsDiscogsWantlist.add(albumDiscogsWantlist);
		}

		br.close();
		
		System.out.println(albumsDiscogsWantlist);
		return albumsDiscogsWantlist;
	}

}