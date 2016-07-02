
package ws.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Picagem_QNAME = new QName("http://server.ws/", "picagem");
    private final static QName _PicagemResponse_QNAME = new QName("http://server.ws/", "picagemResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Picagem }
     * 
     */
    public Picagem createPicagem() {
        return new Picagem();
    }

    /**
     * Create an instance of {@link PicagemResponse }
     * 
     */
    public PicagemResponse createPicagemResponse() {
        return new PicagemResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Picagem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws/", name = "picagem")
    public JAXBElement<Picagem> createPicagem(Picagem value) {
        return new JAXBElement<Picagem>(_Picagem_QNAME, Picagem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PicagemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws/", name = "picagemResponse")
    public JAXBElement<PicagemResponse> createPicagemResponse(PicagemResponse value) {
        return new JAXBElement<PicagemResponse>(_PicagemResponse_QNAME, PicagemResponse.class, null, value);
    }

}
