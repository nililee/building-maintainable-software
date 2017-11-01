package eu.sig.training.ch11;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

public class PluginManager {

    // tag::doUploadPlugin[]
    public HttpResponse doUploadPlugin(StaplerRequest req)
        throws IOException, ServletException {
        try {
            Jenkins.getInstance().checkPermission(UPLOAD_PLUGINS);

            ServletFileUpload upload = new ServletFileUpload(
                new DiskFileItemFactory());

            // 요청을 파싱한다.
            FileItem fileItem = (FileItem)upload.parseRequest(req).get(0);
            String fileName = Util.getFileName(fileItem.getName());
            if ("".equals(fileName)) {
                return new HttpRedirect("advanced");
            }
            // 새 jpi 및 옛 hpi 업로드만 허용한다.
            if (!fileName.endsWith(".jpi") && !fileName.endsWith(".hpi")) {
                throw new Failure("Not a plugin: " + fileName);
            }

            // 먼저, 임시 파일로 복사한다.
            File t = File.createTempFile("uploaded", ".jpi");
            t.deleteOnExit();
            fileItem.write(t);
            fileItem.delete();

            final String baseName = identifyPluginShortName(t);

            pluginUploaded = true;

            // 동적으로 로딩 가능한 더미 플러그인을 만든다.
            // (필요 시 InstallationJob는 강제로 재시작한다)
            JSONObject cfg = new JSONObject().element("name", baseName)
                .element("version", "0"). // 사용하지 않지만 필수값이다
                element("url", t.toURI().toString())
                .element("dependencies", new JSONArray());
            new UpdateSite(UpdateCenter.ID_UPLOAD, null).new Plugin(
                UpdateCenter.ID_UPLOAD, cfg).deploy(true);
            return new HttpRedirect("../updateCenter");
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {// 으음... fileItem.write은 this를 던진다.
            throw new ServletException(e);
        }
    }
    // end::doUploadPlugin[]

    private static final String UPLOAD_PLUGINS = "";
    @SuppressWarnings("unused")
    private boolean pluginUploaded = false;

    public interface HttpResponse {}

    public class HttpRedirect implements HttpResponse {
        public HttpRedirect(@SuppressWarnings("unused") String s) {}
    }

    public class StaplerRequest {}

    private String identifyPluginShortName(@SuppressWarnings("unused") File t) {
        return null;
    }

    public static class Jenkins {
        public static Jenkins getInstance() {
            return new Jenkins();
        }

        public void checkPermission(@SuppressWarnings("unused") String s) {}
    }

    public class JSONObject {

        public JSONObject element(@SuppressWarnings("unused") String string,
            @SuppressWarnings("unused") Object o) {
            return null;
        }
    }

    public class JSONArray {}

    public class FileItem {
        public void write(@SuppressWarnings("unused") File t) {}

        public void delete() {}

        public Object getName() {
            return null;
        }
    }

    public class DiskFileItemFactory {}

    public class ServletFileUpload {
        public ServletFileUpload(
            @SuppressWarnings("unused") DiskFileItemFactory dfif) {}

        public List<FileItem> parseRequest(
            @SuppressWarnings("unused") StaplerRequest req) {
            return null;
        }
    }

    public static class Util {
        public static String getFileName(
            @SuppressWarnings("unused") Object name) {
            return null;
        }
    }

    public class UpdateSite {
        public UpdateSite(@SuppressWarnings("unused") Object o1,
            @SuppressWarnings("unused") Object o2) {}

        public class Plugin {
            public Plugin(@SuppressWarnings("unused") Object o1,
                @SuppressWarnings("unused") Object o2) {}

            public void deploy(@SuppressWarnings("unused") boolean b) {}
        }
    }

    public interface UpdateCenter {
        String ID_UPLOAD = "";
    }

    public class Failure extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public Failure(String message) {
            super(message);
        }
    }
}
