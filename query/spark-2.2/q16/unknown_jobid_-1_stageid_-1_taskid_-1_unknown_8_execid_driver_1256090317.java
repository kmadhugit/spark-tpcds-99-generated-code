/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 020 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 021 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 022 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance9;
/* 024 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance10;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance11;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance12;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance13;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance14;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance15;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance16;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance17;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance18;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance19;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance20;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance21;
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance22;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance23;
/* 038 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance24;
/* 039 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance25;
/* 040 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance26;
/* 041 */   private UnsafeRow scan_result;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 044 */
/* 045 */   public GeneratedIterator(Object[] references) {
/* 046 */     this.references = references;
/* 047 */   }
/* 048 */
/* 049 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 050 */     partitionIndex = index;
/* 051 */     this.inputs = inputs;
/* 052 */     wholestagecodegen_init_0();
/* 053 */     wholestagecodegen_init_1();
/* 054 */
/* 055 */   }
/* 056 */
/* 057 */   private void wholestagecodegen_init_0() {
/* 058 */     scan_input = inputs[0];
/* 059 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 060 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 061 */     scan_scanTime1 = 0;
/* 062 */     scan_batch = null;
/* 063 */     scan_batchIdx = 0;
/* 064 */     scan_colInstance0 = null;
/* 065 */     scan_colInstance1 = null;
/* 066 */     scan_colInstance2 = null;
/* 067 */     scan_colInstance3 = null;
/* 068 */     scan_colInstance4 = null;
/* 069 */     scan_colInstance5 = null;
/* 070 */     scan_colInstance6 = null;
/* 071 */     scan_colInstance7 = null;
/* 072 */     scan_colInstance8 = null;
/* 073 */     scan_colInstance9 = null;
/* 074 */     scan_colInstance10 = null;
/* 075 */     scan_colInstance11 = null;
/* 076 */     scan_colInstance12 = null;
/* 077 */     scan_colInstance13 = null;
/* 078 */     scan_colInstance14 = null;
/* 079 */     scan_colInstance15 = null;
/* 080 */     scan_colInstance16 = null;
/* 081 */     scan_colInstance17 = null;
/* 082 */     scan_colInstance18 = null;
/* 083 */     scan_colInstance19 = null;
/* 084 */     scan_colInstance20 = null;
/* 085 */     scan_colInstance21 = null;
/* 086 */     scan_colInstance22 = null;
/* 087 */     scan_colInstance23 = null;
/* 088 */     scan_colInstance24 = null;
/* 089 */     scan_colInstance25 = null;
/* 090 */     scan_colInstance26 = null;
/* 091 */     scan_result = new UnsafeRow(27);
/* 092 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 093 */
/* 094 */   }
/* 095 */
/* 096 */   private void scan_nextBatch() throws java.io.IOException {
/* 097 */     long getBatchStart = System.nanoTime();
/* 098 */     if (scan_input.hasNext()) {
/* 099 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 100 */       scan_numOutputRows.add(scan_batch.numRows());
/* 101 */       scan_batchIdx = 0;
/* 102 */       scan_colInstance0 = scan_batch.column(0);
/* 103 */       scan_colInstance1 = scan_batch.column(1);
/* 104 */       scan_colInstance2 = scan_batch.column(2);
/* 105 */       scan_colInstance3 = scan_batch.column(3);
/* 106 */       scan_colInstance4 = scan_batch.column(4);
/* 107 */       scan_colInstance5 = scan_batch.column(5);
/* 108 */       scan_colInstance6 = scan_batch.column(6);
/* 109 */       scan_colInstance7 = scan_batch.column(7);
/* 110 */       scan_colInstance8 = scan_batch.column(8);
/* 111 */       scan_colInstance9 = scan_batch.column(9);
/* 112 */       scan_colInstance10 = scan_batch.column(10);
/* 113 */       scan_colInstance11 = scan_batch.column(11);
/* 114 */       scan_colInstance12 = scan_batch.column(12);
/* 115 */       scan_colInstance13 = scan_batch.column(13);
/* 116 */       scan_colInstance14 = scan_batch.column(14);
/* 117 */       scan_colInstance15 = scan_batch.column(15);
/* 118 */       scan_colInstance16 = scan_batch.column(16);
/* 119 */       scan_colInstance17 = scan_batch.column(17);
/* 120 */       scan_colInstance18 = scan_batch.column(18);
/* 121 */       scan_colInstance19 = scan_batch.column(19);
/* 122 */       scan_colInstance20 = scan_batch.column(20);
/* 123 */       scan_colInstance21 = scan_batch.column(21);
/* 124 */       scan_colInstance22 = scan_batch.column(22);
/* 125 */       scan_colInstance23 = scan_batch.column(23);
/* 126 */       scan_colInstance24 = scan_batch.column(24);
/* 127 */       scan_colInstance25 = scan_batch.column(25);
/* 128 */       scan_colInstance26 = scan_batch.column(26);
/* 129 */
/* 130 */     }
/* 131 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 132 */   }
/* 133 */
/* 134 */   private void wholestagecodegen_init_1() {
/* 135 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 27);
/* 136 */
/* 137 */   }
/* 138 */
/* 139 */   protected void processNext() throws java.io.IOException {
/* 140 */     if (scan_batch == null) {
/* 141 */       scan_nextBatch();
/* 142 */     }
/* 143 */     while (scan_batch != null) {
/* 144 */       int scan_numRows = scan_batch.numRows();
/* 145 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 146 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 147 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 148 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 149 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 150 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 151 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 152 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 153 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 154 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 155 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 156 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 157 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 158 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 159 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 160 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 161 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 162 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 163 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 164 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 165 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 166 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 167 */         int scan_value9 = scan_isNull9 ? -1 : (scan_colInstance9.getInt(scan_rowIdx));
/* 168 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 169 */         int scan_value10 = scan_isNull10 ? -1 : (scan_colInstance10.getInt(scan_rowIdx));
/* 170 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 171 */         int scan_value11 = scan_isNull11 ? -1 : (scan_colInstance11.getInt(scan_rowIdx));
/* 172 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 173 */         int scan_value12 = scan_isNull12 ? -1 : (scan_colInstance12.getInt(scan_rowIdx));
/* 174 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 175 */         int scan_value13 = scan_isNull13 ? -1 : (scan_colInstance13.getInt(scan_rowIdx));
/* 176 */         boolean scan_isNull14 = scan_colInstance14.isNullAt(scan_rowIdx);
/* 177 */         int scan_value14 = scan_isNull14 ? -1 : (scan_colInstance14.getInt(scan_rowIdx));
/* 178 */         boolean scan_isNull15 = scan_colInstance15.isNullAt(scan_rowIdx);
/* 179 */         int scan_value15 = scan_isNull15 ? -1 : (scan_colInstance15.getInt(scan_rowIdx));
/* 180 */         boolean scan_isNull16 = scan_colInstance16.isNullAt(scan_rowIdx);
/* 181 */         int scan_value16 = scan_isNull16 ? -1 : (scan_colInstance16.getInt(scan_rowIdx));
/* 182 */         boolean scan_isNull17 = scan_colInstance17.isNullAt(scan_rowIdx);
/* 183 */         double scan_value17 = scan_isNull17 ? -1.0 : (scan_colInstance17.getDouble(scan_rowIdx));
/* 184 */         boolean scan_isNull18 = scan_colInstance18.isNullAt(scan_rowIdx);
/* 185 */         double scan_value18 = scan_isNull18 ? -1.0 : (scan_colInstance18.getDouble(scan_rowIdx));
/* 186 */         boolean scan_isNull19 = scan_colInstance19.isNullAt(scan_rowIdx);
/* 187 */         double scan_value19 = scan_isNull19 ? -1.0 : (scan_colInstance19.getDouble(scan_rowIdx));
/* 188 */         boolean scan_isNull20 = scan_colInstance20.isNullAt(scan_rowIdx);
/* 189 */         double scan_value20 = scan_isNull20 ? -1.0 : (scan_colInstance20.getDouble(scan_rowIdx));
/* 190 */         boolean scan_isNull21 = scan_colInstance21.isNullAt(scan_rowIdx);
/* 191 */         double scan_value21 = scan_isNull21 ? -1.0 : (scan_colInstance21.getDouble(scan_rowIdx));
/* 192 */         boolean scan_isNull22 = scan_colInstance22.isNullAt(scan_rowIdx);
/* 193 */         double scan_value22 = scan_isNull22 ? -1.0 : (scan_colInstance22.getDouble(scan_rowIdx));
/* 194 */         boolean scan_isNull23 = scan_colInstance23.isNullAt(scan_rowIdx);
/* 195 */         double scan_value23 = scan_isNull23 ? -1.0 : (scan_colInstance23.getDouble(scan_rowIdx));
/* 196 */         boolean scan_isNull24 = scan_colInstance24.isNullAt(scan_rowIdx);
/* 197 */         double scan_value24 = scan_isNull24 ? -1.0 : (scan_colInstance24.getDouble(scan_rowIdx));
/* 198 */         boolean scan_isNull25 = scan_colInstance25.isNullAt(scan_rowIdx);
/* 199 */         double scan_value25 = scan_isNull25 ? -1.0 : (scan_colInstance25.getDouble(scan_rowIdx));
/* 200 */         boolean scan_isNull26 = scan_colInstance26.isNullAt(scan_rowIdx);
/* 201 */         int scan_value26 = scan_isNull26 ? -1 : (scan_colInstance26.getInt(scan_rowIdx));
/* 202 */         scan_rowWriter.zeroOutNullBytes();
/* 203 */
/* 204 */         if (scan_isNull) {
/* 205 */           scan_rowWriter.setNullAt(0);
/* 206 */         } else {
/* 207 */           scan_rowWriter.write(0, scan_value);
/* 208 */         }
/* 209 */
/* 210 */         if (scan_isNull1) {
/* 211 */           scan_rowWriter.setNullAt(1);
/* 212 */         } else {
/* 213 */           scan_rowWriter.write(1, scan_value1);
/* 214 */         }
/* 215 */
/* 216 */         if (scan_isNull2) {
/* 217 */           scan_rowWriter.setNullAt(2);
/* 218 */         } else {
/* 219 */           scan_rowWriter.write(2, scan_value2);
/* 220 */         }
/* 221 */
/* 222 */         if (scan_isNull3) {
/* 223 */           scan_rowWriter.setNullAt(3);
/* 224 */         } else {
/* 225 */           scan_rowWriter.write(3, scan_value3);
/* 226 */         }
/* 227 */
/* 228 */         if (scan_isNull4) {
/* 229 */           scan_rowWriter.setNullAt(4);
/* 230 */         } else {
/* 231 */           scan_rowWriter.write(4, scan_value4);
/* 232 */         }
/* 233 */
/* 234 */         if (scan_isNull5) {
/* 235 */           scan_rowWriter.setNullAt(5);
/* 236 */         } else {
/* 237 */           scan_rowWriter.write(5, scan_value5);
/* 238 */         }
/* 239 */
/* 240 */         if (scan_isNull6) {
/* 241 */           scan_rowWriter.setNullAt(6);
/* 242 */         } else {
/* 243 */           scan_rowWriter.write(6, scan_value6);
/* 244 */         }
/* 245 */
/* 246 */         if (scan_isNull7) {
/* 247 */           scan_rowWriter.setNullAt(7);
/* 248 */         } else {
/* 249 */           scan_rowWriter.write(7, scan_value7);
/* 250 */         }
/* 251 */
/* 252 */         if (scan_isNull8) {
/* 253 */           scan_rowWriter.setNullAt(8);
/* 254 */         } else {
/* 255 */           scan_rowWriter.write(8, scan_value8);
/* 256 */         }
/* 257 */
/* 258 */         if (scan_isNull9) {
/* 259 */           scan_rowWriter.setNullAt(9);
/* 260 */         } else {
/* 261 */           scan_rowWriter.write(9, scan_value9);
/* 262 */         }
/* 263 */
/* 264 */         if (scan_isNull10) {
/* 265 */           scan_rowWriter.setNullAt(10);
/* 266 */         } else {
/* 267 */           scan_rowWriter.write(10, scan_value10);
/* 268 */         }
/* 269 */
/* 270 */         if (scan_isNull11) {
/* 271 */           scan_rowWriter.setNullAt(11);
/* 272 */         } else {
/* 273 */           scan_rowWriter.write(11, scan_value11);
/* 274 */         }
/* 275 */
/* 276 */         if (scan_isNull12) {
/* 277 */           scan_rowWriter.setNullAt(12);
/* 278 */         } else {
/* 279 */           scan_rowWriter.write(12, scan_value12);
/* 280 */         }
/* 281 */
/* 282 */         if (scan_isNull13) {
/* 283 */           scan_rowWriter.setNullAt(13);
/* 284 */         } else {
/* 285 */           scan_rowWriter.write(13, scan_value13);
/* 286 */         }
/* 287 */
/* 288 */         if (scan_isNull14) {
/* 289 */           scan_rowWriter.setNullAt(14);
/* 290 */         } else {
/* 291 */           scan_rowWriter.write(14, scan_value14);
/* 292 */         }
/* 293 */
/* 294 */         if (scan_isNull15) {
/* 295 */           scan_rowWriter.setNullAt(15);
/* 296 */         } else {
/* 297 */           scan_rowWriter.write(15, scan_value15);
/* 298 */         }
/* 299 */
/* 300 */         if (scan_isNull16) {
/* 301 */           scan_rowWriter.setNullAt(16);
/* 302 */         } else {
/* 303 */           scan_rowWriter.write(16, scan_value16);
/* 304 */         }
/* 305 */
/* 306 */         if (scan_isNull17) {
/* 307 */           scan_rowWriter.setNullAt(17);
/* 308 */         } else {
/* 309 */           scan_rowWriter.write(17, scan_value17);
/* 310 */         }
/* 311 */
/* 312 */         if (scan_isNull18) {
/* 313 */           scan_rowWriter.setNullAt(18);
/* 314 */         } else {
/* 315 */           scan_rowWriter.write(18, scan_value18);
/* 316 */         }
/* 317 */
/* 318 */         if (scan_isNull19) {
/* 319 */           scan_rowWriter.setNullAt(19);
/* 320 */         } else {
/* 321 */           scan_rowWriter.write(19, scan_value19);
/* 322 */         }
/* 323 */
/* 324 */         if (scan_isNull20) {
/* 325 */           scan_rowWriter.setNullAt(20);
/* 326 */         } else {
/* 327 */           scan_rowWriter.write(20, scan_value20);
/* 328 */         }
/* 329 */
/* 330 */         if (scan_isNull21) {
/* 331 */           scan_rowWriter.setNullAt(21);
/* 332 */         } else {
/* 333 */           scan_rowWriter.write(21, scan_value21);
/* 334 */         }
/* 335 */
/* 336 */         if (scan_isNull22) {
/* 337 */           scan_rowWriter.setNullAt(22);
/* 338 */         } else {
/* 339 */           scan_rowWriter.write(22, scan_value22);
/* 340 */         }
/* 341 */
/* 342 */         if (scan_isNull23) {
/* 343 */           scan_rowWriter.setNullAt(23);
/* 344 */         } else {
/* 345 */           scan_rowWriter.write(23, scan_value23);
/* 346 */         }
/* 347 */
/* 348 */         if (scan_isNull24) {
/* 349 */           scan_rowWriter.setNullAt(24);
/* 350 */         } else {
/* 351 */           scan_rowWriter.write(24, scan_value24);
/* 352 */         }
/* 353 */
/* 354 */         if (scan_isNull25) {
/* 355 */           scan_rowWriter.setNullAt(25);
/* 356 */         } else {
/* 357 */           scan_rowWriter.write(25, scan_value25);
/* 358 */         }
/* 359 */
/* 360 */         if (scan_isNull26) {
/* 361 */           scan_rowWriter.setNullAt(26);
/* 362 */         } else {
/* 363 */           scan_rowWriter.write(26, scan_value26);
/* 364 */         }
/* 365 */         append(scan_result);
/* 366 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 367 */       }
/* 368 */       scan_batchIdx = scan_numRows;
/* 369 */       scan_batch = null;
/* 370 */       scan_nextBatch();
/* 371 */     }
/* 372 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 373 */     scan_scanTime1 = 0;
/* 374 */   }
/* 375 */ }
