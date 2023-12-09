package giss.mad.itinerario.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.netty.handler.ssl.util.LazyX509Certificate;

import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TrustMgr.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class TrustMgrMockitoTest {
    @Autowired
    private TrustMgr trustMgr;

    /**
     * Method under test:
     * {@link TrustMgr#checkClientTrusted(X509Certificate[], String)}
     */
    @Test
    void testCheckClientTrusted() throws UnsupportedEncodingException, CertificateException {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        TrustMgr trustMgr = new TrustMgr();
        trustMgr.checkClientTrusted(new X509Certificate[]{new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"))}, "foo");
    }

    /**
     * Method under test:
     * {@link TrustMgr#checkServerTrusted(X509Certificate[], String)}
     */
    @Test
    void testCheckServerTrusted() throws UnsupportedEncodingException, CertificateException {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        trustMgr.checkServerTrusted(new X509Certificate[]{new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"))}, "foo");
    }

    /**
     * Method under test: {@link TrustMgr#getAcceptedIssuers()}
     */
    @Test
    void testGetAcceptedIssuers() {
        assertEquals(0, trustMgr.getAcceptedIssuers().length);
    }

    /**
     * Method under test: {@link TrustMgr#getSocketFactory()}
     */
    @Test
    void testGetSocketFactory() throws Exception {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SocketFactory.theFactory
        //     SSLSocketFactoryImpl.context

        trustMgr.getSocketFactory();
    }
}
