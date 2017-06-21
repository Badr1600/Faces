package com.microsoft.projectoxford.face.samples.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.microsoft.projectoxford.face.contract.Emotion;
import com.microsoft.projectoxford.face.contract.Face;
import com.microsoft.projectoxford.face.contract.FacialHair;
import com.microsoft.projectoxford.face.contract.HeadPose;
import com.microsoft.projectoxford.face.samples.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView textView = (TextView) findViewById(R.id.textView);

            Face[] result = DetectionActivity.facesResult;
            String s = new String();
            for (int i = 0; i < result.length; i++) {

                s = s + ("FaceID: " + result[i].faceId + "\n");

                s = s + ("Gender: " + result[i].faceAttributes.gender + "\n");
                s = s + ("Age: " + result[i].faceAttributes.age + "\n");
                s = s + ("Emotion: " + getEmotion(result[i].faceAttributes.emotion) + "\n");
                s = s + ("Glasses: " + result[i].faceAttributes.glasses + "\n");
                s = s + ("HeadPose: " + getHeadPose(result[i].faceAttributes.headPose) + "\n");
                s = s + ("FacialHair: " + getFacialHair(result[i].faceAttributes.facialHair) + "\n");
                s = s + ("Smile: " + result[i].faceAttributes.smile + "\n");

                s = s + ("eyeLeftTop: " + result[i].faceLandmarks.eyeLeftTop.x + "\n");
                s = s + ("eyeRightTop: " + result[i].faceLandmarks.eyeRightTop.y + "\n");
                s = s + ("mouthLeft: " + result[i].faceLandmarks.mouthLeft.x + "\n");
                s = s + ("mouthRight: " + result[i].faceLandmarks.mouthRight.y + "\n");
                s = s + ("noseTip: " + result[i].faceLandmarks.noseTip.y + "\n");

                s = s + ("height: " + result[i].faceRectangle.height + "\n");
                s = s + ("left: " + result[i].faceRectangle.left + "\n");
                s = s + ("top: " + result[i].faceRectangle.top + "\n");
                s = s + ("width: " + result[i].faceRectangle.width + "\n");

            }

            textView.setText(s);
        }

    private String getFacialHair(FacialHair facialHair)
    {
        return (facialHair.moustache + facialHair.beard + facialHair.sideburns > 0) ? "Yes" : "No";
    }

    private String getHeadPose(HeadPose headPose)
    {
        return String.format("Pitch: %s, Roll: %s, Yaw: %s", headPose.pitch, headPose.roll, headPose.yaw);
    }

    private String getEmotion(Emotion emotion)
    {
        String emotionType = "";
        double emotionValue = 0.0;
        if (emotion.anger > emotionValue)
        {
            emotionValue = emotion.anger;
            emotionType = "Anger";
        }
        if (emotion.contempt > emotionValue)
        {
            emotionValue = emotion.contempt;
            emotionType = "Contempt";
        }
        if (emotion.disgust > emotionValue)
        {
            emotionValue = emotion.disgust;
            emotionType = "Disgust";
        }
        if (emotion.fear > emotionValue)
        {
            emotionValue = emotion.fear;
            emotionType = "Fear";
        }
        if (emotion.happiness > emotionValue)
        {
            emotionValue = emotion.happiness;
            emotionType = "Happiness";
        }
        if (emotion.neutral > emotionValue)
        {
            emotionValue = emotion.neutral;
            emotionType = "Neutral";
        }
        if (emotion.sadness > emotionValue)
        {
            emotionValue = emotion.sadness;
            emotionType = "Sadness";
        }
        if (emotion.surprise > emotionValue)
        {
            emotionValue = emotion.surprise;
            emotionType = "Surprise";
        }
        return String.format("%s: %f", emotionType, emotionValue);
    }

}
