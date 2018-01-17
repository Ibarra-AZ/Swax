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
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import swax.webservice.entity.AlbumDiscogs;
import swax.webservice.entity.AlbumDiscogsWantlist;

public class FilesTools {
	
//	TODO Add controls on the file uploaded (type, variables...)
//	TODO check out how to limit the size (client validation ?)
	
	public static void uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
		
        byte[] bytes = file.getBytes();
        Path path = Paths.get(request.getSession().getServletContext().
        		getRealPath("files/"+file.getOriginalFilename()));
        Files.write(path, bytes);
	}
	
	public static void uploadImg(MultipartFile file, String imgFileName, HttpServletRequest request) throws IOException {
        String filePath = request.getSession().getServletContext().getRealPath("img/swapAlbums/"+imgFileName+".jpg");
        byte[] bytes = file.getBytes();
        Path path = Paths.get(filePath);
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
		try {
			Files.write(path, bytes);
		} finally {
			lock.unlock();
		}
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
			AlbumDiscogs albumDiscogsWantlist = new AlbumDiscogs(var.get(0), var.get(1), var.get(2), var.get(3), 
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