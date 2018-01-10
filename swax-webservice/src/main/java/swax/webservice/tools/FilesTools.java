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
			AlbumDiscogs albumDiscogs = new AlbumDiscogs(entries[0], entries[1], entries[2], entries[3], 
					entries[4], entries[5], entries[6], entries[7], entries[8], entries[9], entries[10],
					entries[11], entries[12]);
			albumsDiscogs.add(albumDiscogs);
			System.out.println(albumDiscogs.toString());
		}

		br.close();

		return albumsDiscogs;
	}

}