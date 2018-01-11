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

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import swax.webservice.entity.AlbumDiscogs;

public class FilesTools {
	
//	TODO Add controls on the file uploaded (type, variables...)
//	TODO check out how to limit the size (client validation ?)
	
	public static void uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
		
        byte[] bytes = file.getBytes();
        Path path = Paths.get(request.getSession().getServletContext().
        		getRealPath("files/"+file.getOriginalFilename()));
        Files.write(path, bytes);
        
	}

	public static List<AlbumDiscogs> importCSVFile(String filePath) throws IOException {

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
			AlbumDiscogs albumDiscogs = new AlbumDiscogs(var.get(0), var.get(1), var.get(2), var.get(3), 
					var.get(4), var.get(5), var.get(6), var.get(7), var.get(8), var.get(9), var.get(10),
					var.get(11), var.get(12));
			albumsDiscogs.add(albumDiscogs);
		}

		br.close();
		
		return albumsDiscogs;
	}

}