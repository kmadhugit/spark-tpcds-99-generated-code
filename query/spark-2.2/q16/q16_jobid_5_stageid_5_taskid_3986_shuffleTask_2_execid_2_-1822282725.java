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
/* 041 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance27;
/* 042 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance28;
/* 043 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance29;
/* 044 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance30;
/* 045 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance31;
/* 046 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance32;
/* 047 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance33;
/* 048 */   private UnsafeRow scan_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 052 */   private UnsafeRow filter_result;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 055 */   private UnsafeRow project_result;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 058 */
/* 059 */   public GeneratedIterator(Object[] references) {
/* 060 */     this.references = references;
/* 061 */   }
/* 062 */
/* 063 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 064 */     partitionIndex = index;
/* 065 */     this.inputs = inputs;
/* 066 */     wholestagecodegen_init_0();
/* 067 */     wholestagecodegen_init_1();
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */   private void wholestagecodegen_init_0() {
/* 072 */     scan_input = inputs[0];
/* 073 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 074 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 075 */     scan_scanTime1 = 0;
/* 076 */     scan_batch = null;
/* 077 */     scan_batchIdx = 0;
/* 078 */     scan_colInstance0 = null;
/* 079 */     scan_colInstance1 = null;
/* 080 */     scan_colInstance2 = null;
/* 081 */     scan_colInstance3 = null;
/* 082 */     scan_colInstance4 = null;
/* 083 */     scan_colInstance5 = null;
/* 084 */     scan_colInstance6 = null;
/* 085 */     scan_colInstance7 = null;
/* 086 */     scan_colInstance8 = null;
/* 087 */     scan_colInstance9 = null;
/* 088 */     scan_colInstance10 = null;
/* 089 */     scan_colInstance11 = null;
/* 090 */     scan_colInstance12 = null;
/* 091 */     scan_colInstance13 = null;
/* 092 */     scan_colInstance14 = null;
/* 093 */     scan_colInstance15 = null;
/* 094 */     scan_colInstance16 = null;
/* 095 */     scan_colInstance17 = null;
/* 096 */     scan_colInstance18 = null;
/* 097 */     scan_colInstance19 = null;
/* 098 */     scan_colInstance20 = null;
/* 099 */     scan_colInstance21 = null;
/* 100 */     scan_colInstance22 = null;
/* 101 */     scan_colInstance23 = null;
/* 102 */     scan_colInstance24 = null;
/* 103 */     scan_colInstance25 = null;
/* 104 */     scan_colInstance26 = null;
/* 105 */     scan_colInstance27 = null;
/* 106 */     scan_colInstance28 = null;
/* 107 */
/* 108 */   }
/* 109 */
/* 110 */   private void scan_nextBatch() throws java.io.IOException {
/* 111 */     long getBatchStart = System.nanoTime();
/* 112 */     if (scan_input.hasNext()) {
/* 113 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 114 */       scan_numOutputRows.add(scan_batch.numRows());
/* 115 */       scan_batchIdx = 0;
/* 116 */       scan_colInstance0 = scan_batch.column(0);
/* 117 */       scan_colInstance1 = scan_batch.column(1);
/* 118 */       scan_colInstance2 = scan_batch.column(2);
/* 119 */       scan_colInstance3 = scan_batch.column(3);
/* 120 */       scan_colInstance4 = scan_batch.column(4);
/* 121 */       scan_colInstance5 = scan_batch.column(5);
/* 122 */       scan_colInstance6 = scan_batch.column(6);
/* 123 */       scan_colInstance7 = scan_batch.column(7);
/* 124 */       scan_colInstance8 = scan_batch.column(8);
/* 125 */       scan_colInstance9 = scan_batch.column(9);
/* 126 */       scan_colInstance10 = scan_batch.column(10);
/* 127 */       scan_colInstance11 = scan_batch.column(11);
/* 128 */       scan_colInstance12 = scan_batch.column(12);
/* 129 */       scan_colInstance13 = scan_batch.column(13);
/* 130 */       scan_colInstance14 = scan_batch.column(14);
/* 131 */       scan_colInstance15 = scan_batch.column(15);
/* 132 */       scan_colInstance16 = scan_batch.column(16);
/* 133 */       scan_colInstance17 = scan_batch.column(17);
/* 134 */       scan_colInstance18 = scan_batch.column(18);
/* 135 */       scan_colInstance19 = scan_batch.column(19);
/* 136 */       scan_colInstance20 = scan_batch.column(20);
/* 137 */       scan_colInstance21 = scan_batch.column(21);
/* 138 */       scan_colInstance22 = scan_batch.column(22);
/* 139 */       scan_colInstance23 = scan_batch.column(23);
/* 140 */       scan_colInstance24 = scan_batch.column(24);
/* 141 */       scan_colInstance25 = scan_batch.column(25);
/* 142 */       scan_colInstance26 = scan_batch.column(26);
/* 143 */       scan_colInstance27 = scan_batch.column(27);
/* 144 */       scan_colInstance28 = scan_batch.column(28);
/* 145 */       scan_colInstance29 = scan_batch.column(29);
/* 146 */       scan_colInstance30 = scan_batch.column(30);
/* 147 */       scan_colInstance31 = scan_batch.column(31);
/* 148 */       scan_colInstance32 = scan_batch.column(32);
/* 149 */       scan_colInstance33 = scan_batch.column(33);
/* 150 */
/* 151 */     }
/* 152 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 153 */   }
/* 154 */
/* 155 */   private void wholestagecodegen_init_1() {
/* 156 */     scan_colInstance29 = null;
/* 157 */     scan_colInstance30 = null;
/* 158 */     scan_colInstance31 = null;
/* 159 */     scan_colInstance32 = null;
/* 160 */     scan_colInstance33 = null;
/* 161 */     scan_result = new UnsafeRow(34);
/* 162 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 163 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 34);
/* 164 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 165 */     filter_result = new UnsafeRow(34);
/* 166 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 167 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 34);
/* 168 */     project_result = new UnsafeRow(34);
/* 169 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 170 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 34);
/* 171 */
/* 172 */   }
/* 173 */
/* 174 */   protected void processNext() throws java.io.IOException {
/* 175 */     if (scan_batch == null) {
/* 176 */       scan_nextBatch();
/* 177 */     }
/* 178 */     while (scan_batch != null) {
/* 179 */       int scan_numRows = scan_batch.numRows();
/* 180 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 181 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 182 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 183 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 184 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 185 */
/* 186 */         if (!(!(scan_isNull1))) continue;
/* 187 */
/* 188 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 189 */         int scan_value9 = scan_isNull9 ? -1 : (scan_colInstance9.getInt(scan_rowIdx));
/* 190 */
/* 191 */         if (!(!(scan_isNull9))) continue;
/* 192 */
/* 193 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 194 */         int scan_value10 = scan_isNull10 ? -1 : (scan_colInstance10.getInt(scan_rowIdx));
/* 195 */
/* 196 */         if (!(!(scan_isNull10))) continue;
/* 197 */
/* 198 */         filter_numOutputRows.add(1);
/* 199 */
/* 200 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 201 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 202 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 203 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 204 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 205 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 206 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 207 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 208 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 209 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 210 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 211 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 212 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 213 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 214 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 215 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 216 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 217 */         int scan_value11 = scan_isNull11 ? -1 : (scan_colInstance11.getInt(scan_rowIdx));
/* 218 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 219 */         int scan_value12 = scan_isNull12 ? -1 : (scan_colInstance12.getInt(scan_rowIdx));
/* 220 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 221 */         int scan_value13 = scan_isNull13 ? -1 : (scan_colInstance13.getInt(scan_rowIdx));
/* 222 */         boolean scan_isNull14 = scan_colInstance14.isNullAt(scan_rowIdx);
/* 223 */         int scan_value14 = scan_isNull14 ? -1 : (scan_colInstance14.getInt(scan_rowIdx));
/* 224 */         boolean scan_isNull15 = scan_colInstance15.isNullAt(scan_rowIdx);
/* 225 */         int scan_value15 = scan_isNull15 ? -1 : (scan_colInstance15.getInt(scan_rowIdx));
/* 226 */         boolean scan_isNull16 = scan_colInstance16.isNullAt(scan_rowIdx);
/* 227 */         int scan_value16 = scan_isNull16 ? -1 : (scan_colInstance16.getInt(scan_rowIdx));
/* 228 */         boolean scan_isNull17 = scan_colInstance17.isNullAt(scan_rowIdx);
/* 229 */         int scan_value17 = scan_isNull17 ? -1 : (scan_colInstance17.getInt(scan_rowIdx));
/* 230 */         boolean scan_isNull18 = scan_colInstance18.isNullAt(scan_rowIdx);
/* 231 */         double scan_value18 = scan_isNull18 ? -1.0 : (scan_colInstance18.getDouble(scan_rowIdx));
/* 232 */         boolean scan_isNull19 = scan_colInstance19.isNullAt(scan_rowIdx);
/* 233 */         double scan_value19 = scan_isNull19 ? -1.0 : (scan_colInstance19.getDouble(scan_rowIdx));
/* 234 */         boolean scan_isNull20 = scan_colInstance20.isNullAt(scan_rowIdx);
/* 235 */         double scan_value20 = scan_isNull20 ? -1.0 : (scan_colInstance20.getDouble(scan_rowIdx));
/* 236 */         boolean scan_isNull21 = scan_colInstance21.isNullAt(scan_rowIdx);
/* 237 */         double scan_value21 = scan_isNull21 ? -1.0 : (scan_colInstance21.getDouble(scan_rowIdx));
/* 238 */         boolean scan_isNull22 = scan_colInstance22.isNullAt(scan_rowIdx);
/* 239 */         double scan_value22 = scan_isNull22 ? -1.0 : (scan_colInstance22.getDouble(scan_rowIdx));
/* 240 */         boolean scan_isNull23 = scan_colInstance23.isNullAt(scan_rowIdx);
/* 241 */         double scan_value23 = scan_isNull23 ? -1.0 : (scan_colInstance23.getDouble(scan_rowIdx));
/* 242 */         boolean scan_isNull24 = scan_colInstance24.isNullAt(scan_rowIdx);
/* 243 */         double scan_value24 = scan_isNull24 ? -1.0 : (scan_colInstance24.getDouble(scan_rowIdx));
/* 244 */         boolean scan_isNull25 = scan_colInstance25.isNullAt(scan_rowIdx);
/* 245 */         double scan_value25 = scan_isNull25 ? -1.0 : (scan_colInstance25.getDouble(scan_rowIdx));
/* 246 */         boolean scan_isNull26 = scan_colInstance26.isNullAt(scan_rowIdx);
/* 247 */         double scan_value26 = scan_isNull26 ? -1.0 : (scan_colInstance26.getDouble(scan_rowIdx));
/* 248 */         boolean scan_isNull27 = scan_colInstance27.isNullAt(scan_rowIdx);
/* 249 */         double scan_value27 = scan_isNull27 ? -1.0 : (scan_colInstance27.getDouble(scan_rowIdx));
/* 250 */         boolean scan_isNull28 = scan_colInstance28.isNullAt(scan_rowIdx);
/* 251 */         double scan_value28 = scan_isNull28 ? -1.0 : (scan_colInstance28.getDouble(scan_rowIdx));
/* 252 */         boolean scan_isNull29 = scan_colInstance29.isNullAt(scan_rowIdx);
/* 253 */         double scan_value29 = scan_isNull29 ? -1.0 : (scan_colInstance29.getDouble(scan_rowIdx));
/* 254 */         boolean scan_isNull30 = scan_colInstance30.isNullAt(scan_rowIdx);
/* 255 */         double scan_value30 = scan_isNull30 ? -1.0 : (scan_colInstance30.getDouble(scan_rowIdx));
/* 256 */         boolean scan_isNull31 = scan_colInstance31.isNullAt(scan_rowIdx);
/* 257 */         double scan_value31 = scan_isNull31 ? -1.0 : (scan_colInstance31.getDouble(scan_rowIdx));
/* 258 */         boolean scan_isNull32 = scan_colInstance32.isNullAt(scan_rowIdx);
/* 259 */         double scan_value32 = scan_isNull32 ? -1.0 : (scan_colInstance32.getDouble(scan_rowIdx));
/* 260 */         boolean scan_isNull33 = scan_colInstance33.isNullAt(scan_rowIdx);
/* 261 */         int scan_value33 = scan_isNull33 ? -1 : (scan_colInstance33.getInt(scan_rowIdx));
/* 262 */         project_rowWriter.zeroOutNullBytes();
/* 263 */
/* 264 */         if (scan_isNull) {
/* 265 */           project_rowWriter.setNullAt(0);
/* 266 */         } else {
/* 267 */           project_rowWriter.write(0, scan_value);
/* 268 */         }
/* 269 */
/* 270 */         project_rowWriter.write(1, scan_value1);
/* 271 */
/* 272 */         if (scan_isNull2) {
/* 273 */           project_rowWriter.setNullAt(2);
/* 274 */         } else {
/* 275 */           project_rowWriter.write(2, scan_value2);
/* 276 */         }
/* 277 */
/* 278 */         if (scan_isNull3) {
/* 279 */           project_rowWriter.setNullAt(3);
/* 280 */         } else {
/* 281 */           project_rowWriter.write(3, scan_value3);
/* 282 */         }
/* 283 */
/* 284 */         if (scan_isNull4) {
/* 285 */           project_rowWriter.setNullAt(4);
/* 286 */         } else {
/* 287 */           project_rowWriter.write(4, scan_value4);
/* 288 */         }
/* 289 */
/* 290 */         if (scan_isNull5) {
/* 291 */           project_rowWriter.setNullAt(5);
/* 292 */         } else {
/* 293 */           project_rowWriter.write(5, scan_value5);
/* 294 */         }
/* 295 */
/* 296 */         if (scan_isNull6) {
/* 297 */           project_rowWriter.setNullAt(6);
/* 298 */         } else {
/* 299 */           project_rowWriter.write(6, scan_value6);
/* 300 */         }
/* 301 */
/* 302 */         if (scan_isNull7) {
/* 303 */           project_rowWriter.setNullAt(7);
/* 304 */         } else {
/* 305 */           project_rowWriter.write(7, scan_value7);
/* 306 */         }
/* 307 */
/* 308 */         if (scan_isNull8) {
/* 309 */           project_rowWriter.setNullAt(8);
/* 310 */         } else {
/* 311 */           project_rowWriter.write(8, scan_value8);
/* 312 */         }
/* 313 */
/* 314 */         project_rowWriter.write(9, scan_value9);
/* 315 */
/* 316 */         project_rowWriter.write(10, scan_value10);
/* 317 */
/* 318 */         if (scan_isNull11) {
/* 319 */           project_rowWriter.setNullAt(11);
/* 320 */         } else {
/* 321 */           project_rowWriter.write(11, scan_value11);
/* 322 */         }
/* 323 */
/* 324 */         if (scan_isNull12) {
/* 325 */           project_rowWriter.setNullAt(12);
/* 326 */         } else {
/* 327 */           project_rowWriter.write(12, scan_value12);
/* 328 */         }
/* 329 */
/* 330 */         if (scan_isNull13) {
/* 331 */           project_rowWriter.setNullAt(13);
/* 332 */         } else {
/* 333 */           project_rowWriter.write(13, scan_value13);
/* 334 */         }
/* 335 */
/* 336 */         if (scan_isNull14) {
/* 337 */           project_rowWriter.setNullAt(14);
/* 338 */         } else {
/* 339 */           project_rowWriter.write(14, scan_value14);
/* 340 */         }
/* 341 */
/* 342 */         if (scan_isNull15) {
/* 343 */           project_rowWriter.setNullAt(15);
/* 344 */         } else {
/* 345 */           project_rowWriter.write(15, scan_value15);
/* 346 */         }
/* 347 */
/* 348 */         if (scan_isNull16) {
/* 349 */           project_rowWriter.setNullAt(16);
/* 350 */         } else {
/* 351 */           project_rowWriter.write(16, scan_value16);
/* 352 */         }
/* 353 */
/* 354 */         if (scan_isNull17) {
/* 355 */           project_rowWriter.setNullAt(17);
/* 356 */         } else {
/* 357 */           project_rowWriter.write(17, scan_value17);
/* 358 */         }
/* 359 */
/* 360 */         if (scan_isNull18) {
/* 361 */           project_rowWriter.setNullAt(18);
/* 362 */         } else {
/* 363 */           project_rowWriter.write(18, scan_value18);
/* 364 */         }
/* 365 */
/* 366 */         if (scan_isNull19) {
/* 367 */           project_rowWriter.setNullAt(19);
/* 368 */         } else {
/* 369 */           project_rowWriter.write(19, scan_value19);
/* 370 */         }
/* 371 */
/* 372 */         if (scan_isNull20) {
/* 373 */           project_rowWriter.setNullAt(20);
/* 374 */         } else {
/* 375 */           project_rowWriter.write(20, scan_value20);
/* 376 */         }
/* 377 */
/* 378 */         if (scan_isNull21) {
/* 379 */           project_rowWriter.setNullAt(21);
/* 380 */         } else {
/* 381 */           project_rowWriter.write(21, scan_value21);
/* 382 */         }
/* 383 */
/* 384 */         if (scan_isNull22) {
/* 385 */           project_rowWriter.setNullAt(22);
/* 386 */         } else {
/* 387 */           project_rowWriter.write(22, scan_value22);
/* 388 */         }
/* 389 */
/* 390 */         if (scan_isNull23) {
/* 391 */           project_rowWriter.setNullAt(23);
/* 392 */         } else {
/* 393 */           project_rowWriter.write(23, scan_value23);
/* 394 */         }
/* 395 */
/* 396 */         if (scan_isNull24) {
/* 397 */           project_rowWriter.setNullAt(24);
/* 398 */         } else {
/* 399 */           project_rowWriter.write(24, scan_value24);
/* 400 */         }
/* 401 */
/* 402 */         if (scan_isNull25) {
/* 403 */           project_rowWriter.setNullAt(25);
/* 404 */         } else {
/* 405 */           project_rowWriter.write(25, scan_value25);
/* 406 */         }
/* 407 */
/* 408 */         if (scan_isNull26) {
/* 409 */           project_rowWriter.setNullAt(26);
/* 410 */         } else {
/* 411 */           project_rowWriter.write(26, scan_value26);
/* 412 */         }
/* 413 */
/* 414 */         if (scan_isNull27) {
/* 415 */           project_rowWriter.setNullAt(27);
/* 416 */         } else {
/* 417 */           project_rowWriter.write(27, scan_value27);
/* 418 */         }
/* 419 */
/* 420 */         if (scan_isNull28) {
/* 421 */           project_rowWriter.setNullAt(28);
/* 422 */         } else {
/* 423 */           project_rowWriter.write(28, scan_value28);
/* 424 */         }
/* 425 */
/* 426 */         if (scan_isNull29) {
/* 427 */           project_rowWriter.setNullAt(29);
/* 428 */         } else {
/* 429 */           project_rowWriter.write(29, scan_value29);
/* 430 */         }
/* 431 */
/* 432 */         if (scan_isNull30) {
/* 433 */           project_rowWriter.setNullAt(30);
/* 434 */         } else {
/* 435 */           project_rowWriter.write(30, scan_value30);
/* 436 */         }
/* 437 */
/* 438 */         if (scan_isNull31) {
/* 439 */           project_rowWriter.setNullAt(31);
/* 440 */         } else {
/* 441 */           project_rowWriter.write(31, scan_value31);
/* 442 */         }
/* 443 */
/* 444 */         if (scan_isNull32) {
/* 445 */           project_rowWriter.setNullAt(32);
/* 446 */         } else {
/* 447 */           project_rowWriter.write(32, scan_value32);
/* 448 */         }
/* 449 */
/* 450 */         if (scan_isNull33) {
/* 451 */           project_rowWriter.setNullAt(33);
/* 452 */         } else {
/* 453 */           project_rowWriter.write(33, scan_value33);
/* 454 */         }
/* 455 */         append(project_result);
/* 456 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 457 */       }
/* 458 */       scan_batchIdx = scan_numRows;
/* 459 */       scan_batch = null;
/* 460 */       scan_nextBatch();
/* 461 */     }
/* 462 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 463 */     scan_scanTime1 = 0;
/* 464 */   }
/* 465 */ }
