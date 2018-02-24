package swax.web.controller.user;
import java.io.IOException;import java.text.ParseException;import java.util.List;import javax.servlet.http.HttpServletRequest;import org.apache.log4j.Logger;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.ModelAttribute;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.multipart.MultipartFile;import org.springframework.web.servlet.ModelAndView;import swax.web.component.sessionscope.SessionUser;import swax.web.form.PojoModelImportCollectionForm;import swax.web.mav.utils.MavUtil;import swax.webservice.entity.album.AlbumDiscogs;import swax.webservice.entity.user.User;import swax.webservice.service.album.IAlbumCollectedService;import swax.webservice.service.album.IAlbumDiscogsService;import swax.webservice.service.album.IAlbumService;import swax.webservice.service.user.IUserService;
@Controllerpublic class ImportCollectionController {
	@Autowired	private IUserService userService = null;		@Autowired	private IAlbumCollectedService albumCollectedService = null;		@Autowired	private IAlbumService albumService = null;		@Autowired	IAlbumDiscogsService albumDiscogsService = null;		@Autowired	private MavUtil mavUtil = null;		@Autowired	private SessionUser sessionUser;		private Logger logger = Logger.getLogger(this.getClass());		@RequestMapping(value="/importDiscogsCollection")	public ModelAndView importDiscogsCollection(@ModelAttribute(value="importCollectionModelAttribute") 			final PojoModelImportCollectionForm importCollectionForm, HttpServletRequest request, 			ModelAndView mav) throws IOException, ParseException {				logger.debug(this.getClass().getName()+this.getClass()+": importDiscogsCollection");				User user = sessionUser.getSessionUser();						/** START Import with UPLOAD **/				MultipartFile file = importCollectionForm.getDiscogsFilePath();		List<AlbumDiscogs> albumsDiscogs = userService.getDiscogsCollectionUpload(file, request);				/** END Import with UPLOAD **/				albumsDiscogs = albumDiscogsService.trimAlbumsDiscogs(albumsDiscogs);		albumService.updateAlbumTable(albumsDiscogs);		albumCollectedService.createUserCollection(user, albumsDiscogs);				return mav = mavUtil.mySwax(user);	}
}