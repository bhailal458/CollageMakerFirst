//package com.example.sparken02.collage;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.drawable.Drawable;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.RelativeLayout;
//
//import static android.content.ContentValues.TAG;
//
///**
// *
// * Collage View is the parent view of a collage items.
// *
// * @author Juan Carlos Moreno (jcmore2@gmail.com)
// *
// */
//public class CollageView extends RelativeLayout {
//
//	private Context mContext;
//
//	private final String BG = "#FFD4B081";
//
//	private int collageWidth;
//	private int collageHeight;
//
//	private List<CardView> listCards = new ArrayList<CardView>();
//	private boolean isViewRefresh = false;
//	private boolean isCollageFixed = false;
//
//	private static final int INVALID_POINTER_ID = -1;
//	public boolean isRotateEnabled = true;
//	public boolean isTranslateEnabled = true;
//	public boolean isScaleEnabled = true;
//	public float minimumScale = 0.5f;
//	public float maximumScale = 10.0f;
//	private int mActivePointerId = INVALID_POINTER_ID;
//	private float mPrevX;
//	private float mPrevY;
//	private ScaleGestureDetector mScaleGestureDetector;
//	private boolean isLongClick;
//	private CardView card;
//
//	private final Random random = new Random();
//	private static int i = 0;
//
////	public CollageView() {
////			mScaleGestureDetector = new ScaleGestureDetector(
////				new ScaleGestureListener());
////	}
//
//
//
//	public CollageView(Context context) {
//		this(context, null);
//		init(context);
//
//	}
//
//	public CollageView(Context context, AttributeSet attrs) {
//		this(context, attrs, 0);
//		init(context);
//	}
//
//	public CollageView(Context context, AttributeSet attrs, int defStyle) {
//		super(context, attrs, defStyle);
//		init(context);
//	}
//
//
//
//
//	private void init(Context context) {
//		mContext = context;
//		this.setMotionEventSplittingEnabled(true);
//		this.setBackgroundColor(Color.parseColor(BG));
//
//	}
//
//	@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//
//		collageWidth = MeasureSpec.getSize(widthMeasureSpec);
//
//		collageHeight = MeasureSpec.getSize(heightMeasureSpec);
//		Log.i(TAG, "onMeasure: ");
//
//		refreshViews();
//		requestLayout();
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//
//	}
//
//	@Override
//	protected void onDraw(Canvas canvas) {
//		Log.i(TAG, "onDraw: ");
//		super.onDraw(canvas);
//	}
//
//	/**
//	 * Function use to add Cards to internal list
//	 *
//	 * @param card
//	 */
//	private void addViewToList(CardView card) {
//		Log.i(TAG, "addViewToList: ");
//		listCards.add(i,card);
//		i++;
//	}
//
//	/**
//	 * Function use to refresh Cards when Collage has measure
//	 */
//	private void refreshViews() {
//		if (!listCards.isEmpty() && !isViewRefresh) {
//			this.removeAllViews();
//			for (CardView cardView : listCards) {
//				Log.i(TAG, "refreshViews: ");
//				LayoutParams params = new LayoutParams(
//						cardView.getDrawable().getIntrinsicWidth(),
//						cardView.getDrawable().getIntrinsicHeight());
////				int left = random.nextInt(collageWidth) - collageWidth / 4;
////				int top = random.nextInt(collageHeight) - collageHeight / 4;
////				params.leftMargin = left;
////				params.topMargin = top;
////				params.rightMargin = -left;
////				params.bottomMargin = -top;
//				params.leftMargin = 100;
//				params.topMargin = 100;
//				params.rightMargin = 100;
//				params.bottomMargin = 100;
//
//				if (isCollageFixed)
//					cardView.setFixedItem();
//
//				this.addView(cardView, params);
//
//			}
//			isViewRefresh = true;
//		}
//	}
//
//	public void setViewRefresh(boolean isCollageFixed){
//		this.isViewRefresh = isCollageFixed;
//		invalidate();
//	}
//
//	/**
//	 * Methos use to set Collage fixed (Cards cant move)
//	 *
//	 * @param fixedCollage
//	 */
//	public void setFixedCollage(boolean fixedCollage) {
//		isCollageFixed = fixedCollage;
//	}
//
//	/**
//	 * Add Card from Bitmap
//	 *
//	 * @param bm
//	 */
//	public void addCard(Bitmap bm) {
//
//		CardView card = new CardView(mContext);
//		card.setImageBitmap(bm);
//		Log.i(TAG, "addCard: ");
//		addViewToList(card);
//	}
//	public void addCard(CardView cardView) {
//
//		addViewToList(cardView);
//	}
//	/**
//	 * Add Card from Drawable
//	 *
//	 * @param drawable
//	 */
//	public void addCard(Drawable drawable) {
//
//		CardView card = new CardView(mContext);
//		card.setImageDrawable(drawable);
//		addViewToList(card);
//	}
//	/**
//	 * Add Card from resources
//	 *
//	 * @param resId
//	 */
//	public void addCard(int resId) {
//
//		CardView card = new CardView(mContext);
//		card.setImageResource(resId);
//		addViewToList(card);
//	}
//
//	/**
//	 * Create a Collage from list of Bitmaps
//	 *
//	 * @param bmList
//	 *            List of bitmaps
//	 */
//	public void createCollageBitmaps(List<Bitmap> bmList) {
//		for (Bitmap bm : bmList) {
//			Log.i("TAG", "creaqteCollageBitmaps: ");
//			addCard(bm);
//		}
//	}
//	//	public void createCollageBitmaps(Bitmap bm) {
////			addCard(bm);
////
////	}
//	/**
//	 * Create a Collage from list of Drawables
//	 *
//	 * @param drawableList
//	 *            List of Drawables
//	 */
//	public void createCollageDrawables(List<Drawable> drawableList) {
//		for (Drawable drawable : drawableList) {
//			addCard(drawable);
//		}
//	}
//	/**
//	 * Create a Collage from list of Resources
//	 *
//	 * @param resIdList
//	 *            List of resources
//	 */
//	public void createCollageResources(List<Integer> resIdList) {
//
//		for (Integer res : resIdList) {
//			addCard(res.intValue());
//		}
//	}
//
////		public void setRandomPosition(View view) {
////
////			CollageView.TransformInfo randomInfo = new CollageView.TransformInfo();
////
////			randomInfo.deltaScale = Utils.generatRandomPositiveNegitiveValue(2, 0);
////			randomInfo.deltaAngle = Utils.generatRandomPositiveNegitiveValue(4, 2);
////			randomInfo.deltaX = Utils.generatRandomPositiveNegitiveValue(4, 2);
////			randomInfo.deltaY = Utils.generatRandomPositiveNegitiveValue(4, 2);
////			randomInfo.pivotX = Utils.generatRandomPositiveNegitiveValue(4, 2);
////			randomInfo.pivotY = Utils.generatRandomPositiveNegitiveValue(4, 2);
////			randomInfo.minimumScale = minimumScale;
////			randomInfo.maximumScale = 2f;
////
////			move(view, randomInfo);
////		}
////
////		private  float adjustAngle(float degrees) {
////			if (degrees > 180.0f) {
////				degrees -= 360.0f;
////			} else if (degrees < -180.0f) {
////				degrees += 360.0f;
////			}
////
////			return degrees;
////		}
////
////		private  void move(View view, CollageView.TransformInfo info) {
////			computeRenderOffset(view, info.pivotX, info.pivotY);
////			adjustTranslation(view, info.deltaX, info.deltaY);
////
////			// Assume that scaling still maintains aspect ratio.
////			float scale = view.getScaleX() * info.deltaScale;
////			scale = Math.max(info.minimumScale, Math.min(info.maximumScale, scale));
////			view.setScaleX(scale);
////			view.setScaleY(scale);
////
////			float rotation = adjustAngle(view.getRotation() + info.deltaAngle);
////			view.setRotation(rotation);
////		}
////
////		private  void adjustTranslation(View view, float deltaX, float deltaY) {
////			float[] deltaVector = { deltaX, deltaY };
////			view.getMatrix().mapVectors(deltaVector);
////			view.setTranslationX(view.getTranslationX() + deltaVector[0]);
////			view.setTranslationY(view.getTranslationY() + deltaVector[1]);
////		}
////
////		private  void computeRenderOffset(View view, float pivotX,
////										  float pivotY) {
////			if (view.getPivotX() == pivotX && view.getPivotY() == pivotY) {
////				return;
////			}
////
////			float[] prevPoint = { 0.0f, 0.0f };
////			view.getMatrix().mapPoints(prevPoint);
////
////			view.setPivotX(pivotX);
////			view.setPivotY(pivotY);
////
////			float[] currPoint = { 0.0f, 0.0f };
////			view.getMatrix().mapPoints(currPoint);
////
////			float offsetX = currPoint[0] - prevPoint[0];
////			float offsetY = currPoint[1] - prevPoint[1];
////
////			view.setTranslationX(view.getTranslationX() - offsetX);
////			view.setTranslationY(view.getTranslationY() - offsetY);
////		}
////
////		@Override
////		public boolean onTouch(View view, MotionEvent event) {
////			mScaleGestureDetector.onTouchEvent(view, event);
////			isLongClick=true;
////			if (!isTranslateEnabled) {
////				return true;
////			}
////
////			int action = event.getAction();
////			switch (action & event.getActionMasked()) {
////				case MotionEvent.ACTION_DOWN: {
////					mPrevX = event.getX();
////					mPrevY = event.getY();
////
////					// Save the ID of this pointer.
////					mActivePointerId = event.getPointerId(0);
////					Log.i("TAG","down called");
////					break;
////				}
////
////				case MotionEvent.ACTION_MOVE: {
////
////					// Find the index of the active pointer and fetch its position.
////					int pointerIndex = event.findPointerIndex(mActivePointerId);
////					if (pointerIndex != -1) {
////						float currX = event.getX(pointerIndex);
////						float currY = event.getY(pointerIndex);
////
////						// Only move if the ScaleGestureDetector isn't processing a
////						// gesture.
////						if (!mScaleGestureDetector.isInProgress()) {
////							adjustTranslation(view, currX - mPrevX, currY - mPrevY);
////						}
////
////
////					}
////
////					Log.i("TAG","Moved called");
////					break;
////				}
////
////				case MotionEvent.ACTION_CANCEL:
////					mActivePointerId = INVALID_POINTER_ID;
////					Log.i("TAG","cancel called");
////					break;
////
////				case MotionEvent.ACTION_UP:
////					mActivePointerId = INVALID_POINTER_ID;
////					Log.i("TAG","up called");
////					break;
////
////				case MotionEvent.ACTION_POINTER_UP: {
////					// Extract the index of the pointer that left the touch sensor.
////					int pointerIndex = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
////					int pointerId = event.getPointerId(pointerIndex);
////					if (pointerId == mActivePointerId) {
////						// This was our active pointer going up. Choose a new
////						// active pointer and adjust accordingly.
////						int newPointerIndex = pointerIndex == 0 ? 1 : 0;
////						mPrevX = event.getX(newPointerIndex);
////						mPrevY = event.getY(newPointerIndex);
////						mActivePointerId = event.getPointerId(newPointerIndex);
////					}
////
////					break;
////				}
////			}
////
////			return false;
////		}
////
////		public void setTouchListener(boolean touchListener) {
////			this.isLongClick = touchListener;
////		}
////
////		public boolean getTouchListener() {
////			return isLongClick;
////		}
////
////	@Override
////	public boolean onLongClick(View v) {
////		return false;
////	}
////
////
////	private class ScaleGestureListener extends
////				ScaleGestureDetector.SimpleOnScaleGestureListener {
////
////			private float mPivotX;
////			private float mPivotY;
////			private Vector2D mPrevSpanVector = new Vector2D();
////
////			@Override
////			public boolean onScaleBegin(View view, ScaleGestureDetector detector) {
////				mPivotX = detector.getFocusX();
////				mPivotY = detector.getFocusY();
////				mPrevSpanVector.set(detector.getCurrentSpanVector());
////				return true;
////			}
////
////			@Override
////			public boolean onScale(View view, ScaleGestureDetector detector) {
////				CollageView.TransformInfo info = new CollageView.TransformInfo();
////				info.deltaScale = isScaleEnabled ? detector.getScaleFactor() : 1.0f;
////				info.deltaAngle = isRotateEnabled ? Vector2D.getAngle(
////						mPrevSpanVector, detector.getCurrentSpanVector()) : 0.0f;
////				info.deltaX = isTranslateEnabled ? detector.getFocusX() - mPivotX
////						: 0.0f;
////				info.deltaY = isTranslateEnabled ? detector.getFocusY() - mPivotY
////						: 0.0f;
////				info.pivotX = mPivotX;
////				info.pivotY = mPivotY;
////				info.minimumScale = minimumScale;
////				info.maximumScale = maximumScale;
////
////				move(view, info);
////				return false;
////			}
////		}
////
////		private class TransformInfo {
////
////			public float deltaX;
////			public float deltaY;
////			public float deltaScale;
////			public float deltaAngle;
////			public float pivotX;
////			public float pivotY;
////			public float minimumScale;
////			public float maximumScale;
////		}
//
//}