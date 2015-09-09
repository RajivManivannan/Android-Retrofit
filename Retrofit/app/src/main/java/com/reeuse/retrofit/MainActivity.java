package com.reeuse.retrofit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.reeuse.retrofit.helper.RetrofitHelper;
import com.reeuse.retrofit.model.DeleteCallback;
import com.reeuse.retrofit.model.ProductCollection;
import com.reeuse.retrofit.model.Upload;
import com.reeuse.retrofit.model.UserDetails;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;
import retrofit.mime.TypedString;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int SELECT_PHOTO = 101;
    private ImageButton pickBtn;
    private File imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        (findViewById(R.id.main_post_btn)).setOnClickListener(this);
        (findViewById(R.id.main_get_btn)).setOnClickListener(this);
        (findViewById(R.id.main_delete_btn)).setOnClickListener(this);
        (pickBtn = (ImageButton)findViewById(R.id.main_img_button)).setOnClickListener(this);
        (findViewById(R.id.main_upload_btn)).setOnClickListener(this);
    }

    private void getMethod() {
        new RetrofitHelper().getInstance().getProductCollection(new Callback<ProductCollection>() {
            @Override
            public void success(ProductCollection productCollection, Response response) {
                showToast("Product count: " + productCollection.getCount());
            }

            @Override
            public void failure(RetrofitError error) {
                showToast(error.getMessage());
            }
        });
    }

    private void postMethod(Map<String, String> loginRequestParam) {
        new RetrofitHelper().getInstance().getUserDetails(loginRequestParam, new Callback<UserDetails>() {
            @Override
            public void success(UserDetails userDetails, Response response) {

                showToast("Login Username: " + userDetails.getUserName());
            }

            @Override
            public void failure(RetrofitError error) {
                showToast(error.getMessage());
            }
        });

    }

    private void deleteMethod(String deleteUserRequestParam) {
        new RetrofitHelper().getInstance().deleteUser(deleteUserRequestParam, new Callback<DeleteCallback>() {
            @Override
            public void success(DeleteCallback deleteCallback, Response response) {
                showToast(deleteCallback.getMessage());
            }

            @Override
            public void failure(RetrofitError error) {
                showToast(error.getMessage());
            }
        });
    }


    private void postMultiBodyMethod(String fileName,File imageFile) {
        new RetrofitHelper().getInstance().uploadImage(new TypedFile("image/*", imageFile), new TypedString(fileName), new Callback<Upload>() {
            @Override
            public void success(Upload upload, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.main_get_btn:
                getMethod();
                break;
            case R.id.main_post_btn:
                Map<String, String> loginRequestParam = new HashMap<>();
                loginRequestParam.put("email", "test@gmail.com");
                loginRequestParam.put("password", "123456");
                postMethod(loginRequestParam);
                break;
            case R.id.main_delete_btn:
                deleteMethod("10");
                break;
            case R.id.main_img_button:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
                break;
            case R.id.main_upload_btn:
               if(imagePath!=null){
                   postMultiBodyMethod("myImage",imagePath);
               }else showToast("Pick Image to Upload");
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        imagePath = new File(imageUri.getPath());
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        pickBtn.setImageBitmap(selectedImage);
                        imageStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        }
    }

    public void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}