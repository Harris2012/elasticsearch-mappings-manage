package cn.savory.esmanage.proxy;

import cn.savory.esmanage.config.GitlabConfig;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Component
public class GitlabProxy {

    @Autowired
    private GitlabConfig gitlabConfig;

    private final static Gson GSON = new Gson();

    public String getContent(String fileName) throws UnsupportedEncodingException {
        //https://the.gitlab.cn/api/v4/projects/251/repository/files/file-001.txt
        String host = String.join("/", gitlabConfig.getHost(), String.valueOf(gitlabConfig.getProjectId()), "repository/files", fileName);

        host = host + "?ref=master";

        String response = rpcGet(host);

        GetFileResponse getFileResponse = GSON.fromJson(response, GetFileResponse.class);
        if (getFileResponse == null) {
            return null;
        }

        byte[] bytes = Base64.getDecoder().decode(getFileResponse.getContent());

        return new String(bytes, "UTF-8");
    }

    public String create(String fileName, String fileContent) {

        //https://the.gitlab.cn/api/v4/projects/251/repository/files/file-001.txt
        String host = String.join("/", gitlabConfig.getHost(), String.valueOf(gitlabConfig.getProjectId()), "repository/files", fileName);

        String content = GSON.toJson(toFilesRequest(fileContent));

        return rpcPost(host, content);
    }

    public String update(String fileName, String fileContent) {

        //https://the.gitlab.cn/api/v4/projects/251/repository/files/file-001.txt
        String host = String.join("/", gitlabConfig.getHost(), String.valueOf(gitlabConfig.getProjectId()), "repository/files", fileName);

        String content = GSON.toJson(toFilesRequest(fileContent));

        return rpcPut(host, content);
    }

    private FilesRequest toFilesRequest(String content) {
        FilesRequest filesRequest = new FilesRequest();
        filesRequest.setAuthorEmail("harriszhang@live.cn");
        filesRequest.setAuthorName("HarrisZhang");
        filesRequest.setBranch("master");
        filesRequest.setContent(content);
        filesRequest.setCommitMessage("update by esmanage tool");

        return filesRequest;
    }

    /**
     * 若成功，返回正文；若失败，返回null
     */
    private String rpcGet(String host) {

        HttpGet httpGet = new HttpGet(host);

        httpGet.addHeader("Content-Type", "application/json");
        httpGet.addHeader("PRIVATE-TOKEN", gitlabConfig.getPrivateToken());

        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse response = httpClient.execute(httpGet)) {

            int status = response.getStatusLine().getStatusCode();
            if (status != HttpStatus.SC_OK) {
                return null;
            }

            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                String result = EntityUtils.toString(httpEntity, "UTF-8");
                EntityUtils.consume(httpEntity);
                return result;
            }

            return null;

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 若成功，返回null；否则返回失败的信息
     */
    private String rpcPost(String host, String content) {
        HttpPost httpPost = new HttpPost(host);

        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("PRIVATE-TOKEN", gitlabConfig.getPrivateToken());

        httpPost.setEntity(new StringEntity(content, "UTF-8"));

        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse response = httpClient.execute(httpPost)) {

            int status = response.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_CREATED) {
                return null;
            }

            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                String result = EntityUtils.toString(httpEntity, "UTF-8");
                EntityUtils.consume(httpEntity);
                return result;
            }

            return null;

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 若成功，返回null；否则返回失败的信息
     */
    private String rpcPut(String host, String content) {
        HttpPut httpPut = new HttpPut(host);

        httpPut.addHeader("Content-Type", "application/json");
        httpPut.addHeader("PRIVATE-TOKEN", gitlabConfig.getPrivateToken());

        httpPut.setEntity(new StringEntity(content, "UTF-8"));

        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse response = httpClient.execute(httpPut)) {

            int status = response.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                return null;
            }

            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                String result = EntityUtils.toString(httpEntity, "UTF-8");
                EntityUtils.consume(httpEntity);
                return result;
            }

            return null;

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * 若成功，返回null；否则，返回失败的信息
     */
    private String call(HttpRequestBase httpRequestBase) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse response = httpClient.execute(httpRequestBase)) {

            int status = response.getStatusLine().getStatusCode();
            if (status != HttpStatus.SC_OK || status == HttpStatus.SC_CREATED) {
                return null;
            }

            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                String result = EntityUtils.toString(httpEntity, "UTF-8");
                EntityUtils.consume(httpEntity);
                return result;
            }

            return null;

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
