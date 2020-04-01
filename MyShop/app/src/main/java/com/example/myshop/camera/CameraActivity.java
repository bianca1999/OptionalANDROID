package com.example.myshop.camera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.example.myshop.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;

public class CameraActivity extends AppCompatActivity {

   String currentImagePath=null;
    private static final int IMAGE_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


    }

   public void captureImage(View view){
        Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(cameraIntent.resolveActivity(getPackageManager())!=null)
        {
            File imageFile=null;

            try
            {
                imageFile=getImageFile();

            }catch (IOException e){
                e.printStackTrace();
            }

            if ( imageFile!=null)
            {
                Uri imageUri= FileProvider.getUriForFile(this,"com.example.android.provider",imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(cameraIntent,IMAGE_REQUEST);
            }
        }
   }

   public void displayImage(View view){
        Intent intent=new Intent(this,DisplayImage.class);
        intent.putExtra("image_path",currentImagePath);
        startActivity(intent);

   }

   private File getImageFile() throws IOException {
       String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
       String imageName="jpg_"+timeStamp+"_";
       File storageDir=getExternalFilesDir(Environment.DIRECTORY_PICTURES);

       File imageFile=File.createTempFile(imageName,".jpg",storageDir);
       currentImagePath=imageFile.getAbsolutePath();
       return imageFile;
   }

}
