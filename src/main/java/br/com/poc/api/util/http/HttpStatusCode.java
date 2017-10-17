package br.com.poc.api.util.http;


public class HttpStatusCode {
	
	// 2xx Success
	public final static int OK = 200;
	public final static int CREATED = 201;
	public final static int ACCEPTED = 202;
	public final static int NO_CONTENT = 204;
	
	// 4xx Client error
	public final static int BAD_REQUEST = 400;
	public final static int UNAUTHORIZED = 401;
	public final static int FORBIDDEN = 403;
	public final static int NOT_FOOUND = 404;
	public final static int CONFLICT = 409;
	public final static int PRECONDITION_FAILED = 412;
	public final static int BUSINESS_ERROR = 460;
	
	
	// 5xx Server error
	public final static int INTERNAL_SERVER_ERROR = 500;
	public final static int NOT_IMPLEMENTED = 501;
	public final static int SERVICE_UNAVAILABLE = 503;
	
}
