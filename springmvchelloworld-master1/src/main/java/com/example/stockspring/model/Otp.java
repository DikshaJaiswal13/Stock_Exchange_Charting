package com.example.stockspring.model;

public class Otp {
	
	private int otpVerification;

	public Otp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Otp(int otpVerification) {
		super();
		this.otpVerification = otpVerification;
	}

	public int getOtpVerification() {
		return otpVerification;
	}

	public void setOtpVerification(int otpVerification) {
		this.otpVerification = otpVerification;
	}

	@Override
	public String toString() {
		return "Otp [otpVerification=" + otpVerification + "]";
	}
}
