package map.exif;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class Exif {
    private final Map<String, String> TAG_LIST = new HashMap<String, String>();

    /**
     * URLを元にExifを設定する
     *
     * @param url
     * @throws JpegProcessingException
     * @throws IOException
     */
    public Exif(URL url) throws JpegProcessingException, IOException {
        URLConnection conn = url.openConnection();
        InputStream in     = conn.getInputStream();
        File file          = File.createTempFile("temp", null);
        OutputStream os    =  new FileOutputStream(file);

        try {
            int b;
            while ((b = in.read()) != -1) {
                os.write(b);
            }
            os.flush();
        } catch(IOException e) {
            throw e;
        } finally {
            os.close();
            in.close();
        }

        setExif(file);
        file.delete();
    }

    /**
     * 対象ファイルからExifを設定する
     *
     * @param file
     * @throws JpegProcessingException
     * @throws IOException
     */
    public Exif(File file) throws JpegProcessingException, IOException {
        setExif(file);
    }

    /**
     * タグ名に紐付く値を返却
     *
     * @param name
     * @return
     */
    public String getValue(String name) {
        return TAG_LIST.get(name);
    }

    /**
     * タグ名の一覧を返却
     *
     * @return
     */
    public List<String> getTagNameList() {
        List<String> list = new ArrayList<String>();
        for(Map.Entry<String, String> e : TAG_LIST.entrySet()) {
            list.add(e.getKey());
        }
        return list;
    }

    private void setExif(File file) throws JpegProcessingException, IOException {
        Metadata metadata = JpegMetadataReader.readMetadata(file);
        Iterable<Directory> directories = metadata.getDirectories();
        for(Directory directory : directories) {
            Collection<Tag> tags = directory.getTags();
            for(Tag tag : tags) {
                TAG_LIST.put(tag.getTagName().trim(), tag.getDescription().trim());
            }
        }
    }
}