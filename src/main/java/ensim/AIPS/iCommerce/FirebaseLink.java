package ensim.AIPS.iCommerce;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import ensim.AIPS.iCommerce.Model.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class FirebaseLink {

    FirebaseApp app;
    DatabaseReference db;

    FirebaseLink() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("firebase-credentials.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://ensim4a-archilog-eshop.firebaseio.com")
                .build();

        this.app = FirebaseApp.initializeApp(options);
        this.db = FirebaseDatabase.getInstance().getReference().child("/products");
    }

    public String getProduct(int i) {
        return db.child("/"+i+"").toString();
    }

    public void addProduct(Product p){
        HashMap<String, Product> list = new HashMap<String, Product>();
        list.put(p.getId()+"", p);
        db.setValueAsync(list);
    }

    public void updateProduct(Product p){
        HashMap<String, Object> list = new HashMap<String, Object>();
        list.put(p.getId()+"", p);
        db.updateChildrenAsync(list);
    }

}
