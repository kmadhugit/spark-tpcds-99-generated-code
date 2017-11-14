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
/* 037 */   private UnsafeRow scan_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 040 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 041 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 043 */   private UnsafeRow bhj_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 046 */
/* 047 */   public GeneratedIterator(Object[] references) {
/* 048 */     this.references = references;
/* 049 */   }
/* 050 */
/* 051 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 052 */     partitionIndex = index;
/* 053 */     this.inputs = inputs;
/* 054 */     wholestagecodegen_init_0();
/* 055 */     wholestagecodegen_init_1();
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private void wholestagecodegen_init_0() {
/* 060 */     scan_input = inputs[0];
/* 061 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 062 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 063 */     scan_scanTime1 = 0;
/* 064 */     scan_batch = null;
/* 065 */     scan_batchIdx = 0;
/* 066 */     scan_colInstance0 = null;
/* 067 */     scan_colInstance1 = null;
/* 068 */     scan_colInstance2 = null;
/* 069 */     scan_colInstance3 = null;
/* 070 */     scan_colInstance4 = null;
/* 071 */     scan_colInstance5 = null;
/* 072 */     scan_colInstance6 = null;
/* 073 */     scan_colInstance7 = null;
/* 074 */     scan_colInstance8 = null;
/* 075 */     scan_colInstance9 = null;
/* 076 */     scan_colInstance10 = null;
/* 077 */     scan_colInstance11 = null;
/* 078 */     scan_colInstance12 = null;
/* 079 */     scan_colInstance13 = null;
/* 080 */     scan_colInstance14 = null;
/* 081 */     scan_colInstance15 = null;
/* 082 */     scan_colInstance16 = null;
/* 083 */     scan_colInstance17 = null;
/* 084 */     scan_colInstance18 = null;
/* 085 */     scan_colInstance19 = null;
/* 086 */     scan_colInstance20 = null;
/* 087 */     scan_colInstance21 = null;
/* 088 */     scan_colInstance22 = null;
/* 089 */     scan_result = new UnsafeRow(23);
/* 090 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 091 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 23);
/* 092 */
/* 093 */   }
/* 094 */
/* 095 */   private void scan_nextBatch() throws java.io.IOException {
/* 096 */     long getBatchStart = System.nanoTime();
/* 097 */     if (scan_input.hasNext()) {
/* 098 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 099 */       scan_numOutputRows.add(scan_batch.numRows());
/* 100 */       scan_batchIdx = 0;
/* 101 */       scan_colInstance0 = scan_batch.column(0);
/* 102 */       scan_colInstance1 = scan_batch.column(1);
/* 103 */       scan_colInstance2 = scan_batch.column(2);
/* 104 */       scan_colInstance3 = scan_batch.column(3);
/* 105 */       scan_colInstance4 = scan_batch.column(4);
/* 106 */       scan_colInstance5 = scan_batch.column(5);
/* 107 */       scan_colInstance6 = scan_batch.column(6);
/* 108 */       scan_colInstance7 = scan_batch.column(7);
/* 109 */       scan_colInstance8 = scan_batch.column(8);
/* 110 */       scan_colInstance9 = scan_batch.column(9);
/* 111 */       scan_colInstance10 = scan_batch.column(10);
/* 112 */       scan_colInstance11 = scan_batch.column(11);
/* 113 */       scan_colInstance12 = scan_batch.column(12);
/* 114 */       scan_colInstance13 = scan_batch.column(13);
/* 115 */       scan_colInstance14 = scan_batch.column(14);
/* 116 */       scan_colInstance15 = scan_batch.column(15);
/* 117 */       scan_colInstance16 = scan_batch.column(16);
/* 118 */       scan_colInstance17 = scan_batch.column(17);
/* 119 */       scan_colInstance18 = scan_batch.column(18);
/* 120 */       scan_colInstance19 = scan_batch.column(19);
/* 121 */       scan_colInstance20 = scan_batch.column(20);
/* 122 */       scan_colInstance21 = scan_batch.column(21);
/* 123 */       scan_colInstance22 = scan_batch.column(22);
/* 124 */
/* 125 */     }
/* 126 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 127 */   }
/* 128 */
/* 129 */   private void wholestagecodegen_init_1() {
/* 130 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[2];
/* 131 */
/* 132 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 133 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 134 */
/* 135 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 136 */     bhj_result = new UnsafeRow(51);
/* 137 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 384);
/* 138 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 51);
/* 139 */
/* 140 */   }
/* 141 */
/* 142 */   protected void processNext() throws java.io.IOException {
/* 143 */     if (scan_batch == null) {
/* 144 */       scan_nextBatch();
/* 145 */     }
/* 146 */     while (scan_batch != null) {
/* 147 */       int scan_numRows = scan_batch.numRows();
/* 148 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 149 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 150 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 151 */         boolean scan_isNull22 = scan_colInstance22.isNullAt(scan_rowIdx);
/* 152 */         int scan_value22 = scan_isNull22 ? -1 : (scan_colInstance22.getInt(scan_rowIdx));
/* 153 */
/* 154 */         // generate join key for stream side
/* 155 */
/* 156 */         boolean bhj_isNull = scan_isNull22;
/* 157 */         long bhj_value = -1L;
/* 158 */         if (!scan_isNull22) {
/* 159 */           bhj_value = (long) scan_value22;
/* 160 */         }
/* 161 */         // find matches from HashedRelation
/* 162 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 163 */         if (bhj_matched == null) continue;
/* 164 */
/* 165 */         bhj_numOutputRows.add(1);
/* 166 */
/* 167 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 168 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 169 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 170 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 171 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 172 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 173 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 174 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 175 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 176 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 177 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 178 */         int scan_value5 = scan_isNull5 ? -1 : (scan_colInstance5.getInt(scan_rowIdx));
/* 179 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 180 */         int scan_value6 = scan_isNull6 ? -1 : (scan_colInstance6.getInt(scan_rowIdx));
/* 181 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 182 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 183 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 184 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 185 */         boolean scan_isNull9 = scan_colInstance9.isNullAt(scan_rowIdx);
/* 186 */         int scan_value9 = scan_isNull9 ? -1 : (scan_colInstance9.getInt(scan_rowIdx));
/* 187 */         boolean scan_isNull10 = scan_colInstance10.isNullAt(scan_rowIdx);
/* 188 */         double scan_value10 = scan_isNull10 ? -1.0 : (scan_colInstance10.getDouble(scan_rowIdx));
/* 189 */         boolean scan_isNull11 = scan_colInstance11.isNullAt(scan_rowIdx);
/* 190 */         double scan_value11 = scan_isNull11 ? -1.0 : (scan_colInstance11.getDouble(scan_rowIdx));
/* 191 */         boolean scan_isNull12 = scan_colInstance12.isNullAt(scan_rowIdx);
/* 192 */         double scan_value12 = scan_isNull12 ? -1.0 : (scan_colInstance12.getDouble(scan_rowIdx));
/* 193 */         boolean scan_isNull13 = scan_colInstance13.isNullAt(scan_rowIdx);
/* 194 */         double scan_value13 = scan_isNull13 ? -1.0 : (scan_colInstance13.getDouble(scan_rowIdx));
/* 195 */         boolean scan_isNull14 = scan_colInstance14.isNullAt(scan_rowIdx);
/* 196 */         double scan_value14 = scan_isNull14 ? -1.0 : (scan_colInstance14.getDouble(scan_rowIdx));
/* 197 */         boolean scan_isNull15 = scan_colInstance15.isNullAt(scan_rowIdx);
/* 198 */         double scan_value15 = scan_isNull15 ? -1.0 : (scan_colInstance15.getDouble(scan_rowIdx));
/* 199 */         boolean scan_isNull16 = scan_colInstance16.isNullAt(scan_rowIdx);
/* 200 */         double scan_value16 = scan_isNull16 ? -1.0 : (scan_colInstance16.getDouble(scan_rowIdx));
/* 201 */         boolean scan_isNull17 = scan_colInstance17.isNullAt(scan_rowIdx);
/* 202 */         double scan_value17 = scan_isNull17 ? -1.0 : (scan_colInstance17.getDouble(scan_rowIdx));
/* 203 */         boolean scan_isNull18 = scan_colInstance18.isNullAt(scan_rowIdx);
/* 204 */         double scan_value18 = scan_isNull18 ? -1.0 : (scan_colInstance18.getDouble(scan_rowIdx));
/* 205 */         boolean scan_isNull19 = scan_colInstance19.isNullAt(scan_rowIdx);
/* 206 */         double scan_value19 = scan_isNull19 ? -1.0 : (scan_colInstance19.getDouble(scan_rowIdx));
/* 207 */         boolean scan_isNull20 = scan_colInstance20.isNullAt(scan_rowIdx);
/* 208 */         double scan_value20 = scan_isNull20 ? -1.0 : (scan_colInstance20.getDouble(scan_rowIdx));
/* 209 */         boolean scan_isNull21 = scan_colInstance21.isNullAt(scan_rowIdx);
/* 210 */         double scan_value21 = scan_isNull21 ? -1.0 : (scan_colInstance21.getDouble(scan_rowIdx));
/* 211 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 212 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 213 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 214 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 215 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 216 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 217 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 218 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 219 */         boolean bhj_isNull6 = bhj_matched.isNullAt(4);
/* 220 */         int bhj_value6 = bhj_isNull6 ? -1 : (bhj_matched.getInt(4));
/* 221 */         boolean bhj_isNull7 = bhj_matched.isNullAt(5);
/* 222 */         int bhj_value7 = bhj_isNull7 ? -1 : (bhj_matched.getInt(5));
/* 223 */         boolean bhj_isNull8 = bhj_matched.isNullAt(6);
/* 224 */         int bhj_value8 = bhj_isNull8 ? -1 : (bhj_matched.getInt(6));
/* 225 */         boolean bhj_isNull9 = bhj_matched.isNullAt(7);
/* 226 */         int bhj_value9 = bhj_isNull9 ? -1 : (bhj_matched.getInt(7));
/* 227 */         boolean bhj_isNull10 = bhj_matched.isNullAt(8);
/* 228 */         int bhj_value10 = bhj_isNull10 ? -1 : (bhj_matched.getInt(8));
/* 229 */         boolean bhj_isNull11 = bhj_matched.isNullAt(9);
/* 230 */         int bhj_value11 = bhj_isNull11 ? -1 : (bhj_matched.getInt(9));
/* 231 */         boolean bhj_isNull12 = bhj_matched.isNullAt(10);
/* 232 */         int bhj_value12 = bhj_isNull12 ? -1 : (bhj_matched.getInt(10));
/* 233 */         boolean bhj_isNull13 = bhj_matched.isNullAt(11);
/* 234 */         int bhj_value13 = bhj_isNull13 ? -1 : (bhj_matched.getInt(11));
/* 235 */         boolean bhj_isNull14 = bhj_matched.isNullAt(12);
/* 236 */         int bhj_value14 = bhj_isNull14 ? -1 : (bhj_matched.getInt(12));
/* 237 */         boolean bhj_isNull15 = bhj_matched.isNullAt(13);
/* 238 */         int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched.getInt(13));
/* 239 */         boolean bhj_isNull16 = bhj_matched.isNullAt(14);
/* 240 */         UTF8String bhj_value16 = bhj_isNull16 ? null : (bhj_matched.getUTF8String(14));
/* 241 */         boolean bhj_isNull17 = bhj_matched.isNullAt(15);
/* 242 */         UTF8String bhj_value17 = bhj_isNull17 ? null : (bhj_matched.getUTF8String(15));
/* 243 */         boolean bhj_isNull18 = bhj_matched.isNullAt(16);
/* 244 */         UTF8String bhj_value18 = bhj_isNull18 ? null : (bhj_matched.getUTF8String(16));
/* 245 */         boolean bhj_isNull19 = bhj_matched.isNullAt(17);
/* 246 */         UTF8String bhj_value19 = bhj_isNull19 ? null : (bhj_matched.getUTF8String(17));
/* 247 */         boolean bhj_isNull20 = bhj_matched.isNullAt(18);
/* 248 */         UTF8String bhj_value20 = bhj_isNull20 ? null : (bhj_matched.getUTF8String(18));
/* 249 */         boolean bhj_isNull21 = bhj_matched.isNullAt(19);
/* 250 */         int bhj_value21 = bhj_isNull21 ? -1 : (bhj_matched.getInt(19));
/* 251 */         boolean bhj_isNull22 = bhj_matched.isNullAt(20);
/* 252 */         int bhj_value22 = bhj_isNull22 ? -1 : (bhj_matched.getInt(20));
/* 253 */         boolean bhj_isNull23 = bhj_matched.isNullAt(21);
/* 254 */         int bhj_value23 = bhj_isNull23 ? -1 : (bhj_matched.getInt(21));
/* 255 */         boolean bhj_isNull24 = bhj_matched.isNullAt(22);
/* 256 */         int bhj_value24 = bhj_isNull24 ? -1 : (bhj_matched.getInt(22));
/* 257 */         boolean bhj_isNull25 = bhj_matched.isNullAt(23);
/* 258 */         UTF8String bhj_value25 = bhj_isNull25 ? null : (bhj_matched.getUTF8String(23));
/* 259 */         boolean bhj_isNull26 = bhj_matched.isNullAt(24);
/* 260 */         UTF8String bhj_value26 = bhj_isNull26 ? null : (bhj_matched.getUTF8String(24));
/* 261 */         boolean bhj_isNull27 = bhj_matched.isNullAt(25);
/* 262 */         UTF8String bhj_value27 = bhj_isNull27 ? null : (bhj_matched.getUTF8String(25));
/* 263 */         boolean bhj_isNull28 = bhj_matched.isNullAt(26);
/* 264 */         UTF8String bhj_value28 = bhj_isNull28 ? null : (bhj_matched.getUTF8String(26));
/* 265 */         boolean bhj_isNull29 = bhj_matched.isNullAt(27);
/* 266 */         UTF8String bhj_value29 = bhj_isNull29 ? null : (bhj_matched.getUTF8String(27));
/* 267 */         bhj_holder.reset();
/* 268 */
/* 269 */         bhj_rowWriter.zeroOutNullBytes();
/* 270 */
/* 271 */         if (scan_isNull) {
/* 272 */           bhj_rowWriter.setNullAt(0);
/* 273 */         } else {
/* 274 */           bhj_rowWriter.write(0, scan_value);
/* 275 */         }
/* 276 */
/* 277 */         if (scan_isNull1) {
/* 278 */           bhj_rowWriter.setNullAt(1);
/* 279 */         } else {
/* 280 */           bhj_rowWriter.write(1, scan_value1);
/* 281 */         }
/* 282 */
/* 283 */         if (scan_isNull2) {
/* 284 */           bhj_rowWriter.setNullAt(2);
/* 285 */         } else {
/* 286 */           bhj_rowWriter.write(2, scan_value2);
/* 287 */         }
/* 288 */
/* 289 */         if (scan_isNull3) {
/* 290 */           bhj_rowWriter.setNullAt(3);
/* 291 */         } else {
/* 292 */           bhj_rowWriter.write(3, scan_value3);
/* 293 */         }
/* 294 */
/* 295 */         if (scan_isNull4) {
/* 296 */           bhj_rowWriter.setNullAt(4);
/* 297 */         } else {
/* 298 */           bhj_rowWriter.write(4, scan_value4);
/* 299 */         }
/* 300 */
/* 301 */         if (scan_isNull5) {
/* 302 */           bhj_rowWriter.setNullAt(5);
/* 303 */         } else {
/* 304 */           bhj_rowWriter.write(5, scan_value5);
/* 305 */         }
/* 306 */
/* 307 */         if (scan_isNull6) {
/* 308 */           bhj_rowWriter.setNullAt(6);
/* 309 */         } else {
/* 310 */           bhj_rowWriter.write(6, scan_value6);
/* 311 */         }
/* 312 */
/* 313 */         if (scan_isNull7) {
/* 314 */           bhj_rowWriter.setNullAt(7);
/* 315 */         } else {
/* 316 */           bhj_rowWriter.write(7, scan_value7);
/* 317 */         }
/* 318 */
/* 319 */         if (scan_isNull8) {
/* 320 */           bhj_rowWriter.setNullAt(8);
/* 321 */         } else {
/* 322 */           bhj_rowWriter.write(8, scan_value8);
/* 323 */         }
/* 324 */
/* 325 */         if (scan_isNull9) {
/* 326 */           bhj_rowWriter.setNullAt(9);
/* 327 */         } else {
/* 328 */           bhj_rowWriter.write(9, scan_value9);
/* 329 */         }
/* 330 */
/* 331 */         if (scan_isNull10) {
/* 332 */           bhj_rowWriter.setNullAt(10);
/* 333 */         } else {
/* 334 */           bhj_rowWriter.write(10, scan_value10);
/* 335 */         }
/* 336 */
/* 337 */         if (scan_isNull11) {
/* 338 */           bhj_rowWriter.setNullAt(11);
/* 339 */         } else {
/* 340 */           bhj_rowWriter.write(11, scan_value11);
/* 341 */         }
/* 342 */
/* 343 */         if (scan_isNull12) {
/* 344 */           bhj_rowWriter.setNullAt(12);
/* 345 */         } else {
/* 346 */           bhj_rowWriter.write(12, scan_value12);
/* 347 */         }
/* 348 */
/* 349 */         if (scan_isNull13) {
/* 350 */           bhj_rowWriter.setNullAt(13);
/* 351 */         } else {
/* 352 */           bhj_rowWriter.write(13, scan_value13);
/* 353 */         }
/* 354 */
/* 355 */         if (scan_isNull14) {
/* 356 */           bhj_rowWriter.setNullAt(14);
/* 357 */         } else {
/* 358 */           bhj_rowWriter.write(14, scan_value14);
/* 359 */         }
/* 360 */
/* 361 */         if (scan_isNull15) {
/* 362 */           bhj_rowWriter.setNullAt(15);
/* 363 */         } else {
/* 364 */           bhj_rowWriter.write(15, scan_value15);
/* 365 */         }
/* 366 */
/* 367 */         if (scan_isNull16) {
/* 368 */           bhj_rowWriter.setNullAt(16);
/* 369 */         } else {
/* 370 */           bhj_rowWriter.write(16, scan_value16);
/* 371 */         }
/* 372 */
/* 373 */         if (scan_isNull17) {
/* 374 */           bhj_rowWriter.setNullAt(17);
/* 375 */         } else {
/* 376 */           bhj_rowWriter.write(17, scan_value17);
/* 377 */         }
/* 378 */
/* 379 */         if (scan_isNull18) {
/* 380 */           bhj_rowWriter.setNullAt(18);
/* 381 */         } else {
/* 382 */           bhj_rowWriter.write(18, scan_value18);
/* 383 */         }
/* 384 */
/* 385 */         if (scan_isNull19) {
/* 386 */           bhj_rowWriter.setNullAt(19);
/* 387 */         } else {
/* 388 */           bhj_rowWriter.write(19, scan_value19);
/* 389 */         }
/* 390 */
/* 391 */         if (scan_isNull20) {
/* 392 */           bhj_rowWriter.setNullAt(20);
/* 393 */         } else {
/* 394 */           bhj_rowWriter.write(20, scan_value20);
/* 395 */         }
/* 396 */
/* 397 */         if (scan_isNull21) {
/* 398 */           bhj_rowWriter.setNullAt(21);
/* 399 */         } else {
/* 400 */           bhj_rowWriter.write(21, scan_value21);
/* 401 */         }
/* 402 */
/* 403 */         if (scan_isNull22) {
/* 404 */           bhj_rowWriter.setNullAt(22);
/* 405 */         } else {
/* 406 */           bhj_rowWriter.write(22, scan_value22);
/* 407 */         }
/* 408 */
/* 409 */         if (bhj_isNull2) {
/* 410 */           bhj_rowWriter.setNullAt(23);
/* 411 */         } else {
/* 412 */           bhj_rowWriter.write(23, bhj_value2);
/* 413 */         }
/* 414 */
/* 415 */         if (bhj_isNull3) {
/* 416 */           bhj_rowWriter.setNullAt(24);
/* 417 */         } else {
/* 418 */           bhj_rowWriter.write(24, bhj_value3);
/* 419 */         }
/* 420 */
/* 421 */         if (bhj_isNull4) {
/* 422 */           bhj_rowWriter.setNullAt(25);
/* 423 */         } else {
/* 424 */           bhj_rowWriter.write(25, bhj_value4);
/* 425 */         }
/* 426 */
/* 427 */         if (bhj_isNull5) {
/* 428 */           bhj_rowWriter.setNullAt(26);
/* 429 */         } else {
/* 430 */           bhj_rowWriter.write(26, bhj_value5);
/* 431 */         }
/* 432 */
/* 433 */         if (bhj_isNull6) {
/* 434 */           bhj_rowWriter.setNullAt(27);
/* 435 */         } else {
/* 436 */           bhj_rowWriter.write(27, bhj_value6);
/* 437 */         }
/* 438 */
/* 439 */         if (bhj_isNull7) {
/* 440 */           bhj_rowWriter.setNullAt(28);
/* 441 */         } else {
/* 442 */           bhj_rowWriter.write(28, bhj_value7);
/* 443 */         }
/* 444 */
/* 445 */         if (bhj_isNull8) {
/* 446 */           bhj_rowWriter.setNullAt(29);
/* 447 */         } else {
/* 448 */           bhj_rowWriter.write(29, bhj_value8);
/* 449 */         }
/* 450 */
/* 451 */         if (bhj_isNull9) {
/* 452 */           bhj_rowWriter.setNullAt(30);
/* 453 */         } else {
/* 454 */           bhj_rowWriter.write(30, bhj_value9);
/* 455 */         }
/* 456 */
/* 457 */         if (bhj_isNull10) {
/* 458 */           bhj_rowWriter.setNullAt(31);
/* 459 */         } else {
/* 460 */           bhj_rowWriter.write(31, bhj_value10);
/* 461 */         }
/* 462 */
/* 463 */         if (bhj_isNull11) {
/* 464 */           bhj_rowWriter.setNullAt(32);
/* 465 */         } else {
/* 466 */           bhj_rowWriter.write(32, bhj_value11);
/* 467 */         }
/* 468 */
/* 469 */         if (bhj_isNull12) {
/* 470 */           bhj_rowWriter.setNullAt(33);
/* 471 */         } else {
/* 472 */           bhj_rowWriter.write(33, bhj_value12);
/* 473 */         }
/* 474 */
/* 475 */         if (bhj_isNull13) {
/* 476 */           bhj_rowWriter.setNullAt(34);
/* 477 */         } else {
/* 478 */           bhj_rowWriter.write(34, bhj_value13);
/* 479 */         }
/* 480 */
/* 481 */         if (bhj_isNull14) {
/* 482 */           bhj_rowWriter.setNullAt(35);
/* 483 */         } else {
/* 484 */           bhj_rowWriter.write(35, bhj_value14);
/* 485 */         }
/* 486 */
/* 487 */         if (bhj_isNull15) {
/* 488 */           bhj_rowWriter.setNullAt(36);
/* 489 */         } else {
/* 490 */           bhj_rowWriter.write(36, bhj_value15);
/* 491 */         }
/* 492 */
/* 493 */         if (bhj_isNull16) {
/* 494 */           bhj_rowWriter.setNullAt(37);
/* 495 */         } else {
/* 496 */           bhj_rowWriter.write(37, bhj_value16);
/* 497 */         }
/* 498 */
/* 499 */         if (bhj_isNull17) {
/* 500 */           bhj_rowWriter.setNullAt(38);
/* 501 */         } else {
/* 502 */           bhj_rowWriter.write(38, bhj_value17);
/* 503 */         }
/* 504 */
/* 505 */         if (bhj_isNull18) {
/* 506 */           bhj_rowWriter.setNullAt(39);
/* 507 */         } else {
/* 508 */           bhj_rowWriter.write(39, bhj_value18);
/* 509 */         }
/* 510 */
/* 511 */         if (bhj_isNull19) {
/* 512 */           bhj_rowWriter.setNullAt(40);
/* 513 */         } else {
/* 514 */           bhj_rowWriter.write(40, bhj_value19);
/* 515 */         }
/* 516 */
/* 517 */         if (bhj_isNull20) {
/* 518 */           bhj_rowWriter.setNullAt(41);
/* 519 */         } else {
/* 520 */           bhj_rowWriter.write(41, bhj_value20);
/* 521 */         }
/* 522 */
/* 523 */         if (bhj_isNull21) {
/* 524 */           bhj_rowWriter.setNullAt(42);
/* 525 */         } else {
/* 526 */           bhj_rowWriter.write(42, bhj_value21);
/* 527 */         }
/* 528 */
/* 529 */         if (bhj_isNull22) {
/* 530 */           bhj_rowWriter.setNullAt(43);
/* 531 */         } else {
/* 532 */           bhj_rowWriter.write(43, bhj_value22);
/* 533 */         }
/* 534 */
/* 535 */         if (bhj_isNull23) {
/* 536 */           bhj_rowWriter.setNullAt(44);
/* 537 */         } else {
/* 538 */           bhj_rowWriter.write(44, bhj_value23);
/* 539 */         }
/* 540 */
/* 541 */         if (bhj_isNull24) {
/* 542 */           bhj_rowWriter.setNullAt(45);
/* 543 */         } else {
/* 544 */           bhj_rowWriter.write(45, bhj_value24);
/* 545 */         }
/* 546 */
/* 547 */         if (bhj_isNull25) {
/* 548 */           bhj_rowWriter.setNullAt(46);
/* 549 */         } else {
/* 550 */           bhj_rowWriter.write(46, bhj_value25);
/* 551 */         }
/* 552 */
/* 553 */         if (bhj_isNull26) {
/* 554 */           bhj_rowWriter.setNullAt(47);
/* 555 */         } else {
/* 556 */           bhj_rowWriter.write(47, bhj_value26);
/* 557 */         }
/* 558 */
/* 559 */         if (bhj_isNull27) {
/* 560 */           bhj_rowWriter.setNullAt(48);
/* 561 */         } else {
/* 562 */           bhj_rowWriter.write(48, bhj_value27);
/* 563 */         }
/* 564 */
/* 565 */         if (bhj_isNull28) {
/* 566 */           bhj_rowWriter.setNullAt(49);
/* 567 */         } else {
/* 568 */           bhj_rowWriter.write(49, bhj_value28);
/* 569 */         }
/* 570 */
/* 571 */         if (bhj_isNull29) {
/* 572 */           bhj_rowWriter.setNullAt(50);
/* 573 */         } else {
/* 574 */           bhj_rowWriter.write(50, bhj_value29);
/* 575 */         }
/* 576 */         bhj_result.setTotalSize(bhj_holder.totalSize());
/* 577 */         append(bhj_result);
/* 578 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 579 */       }
/* 580 */       scan_batchIdx = scan_numRows;
/* 581 */       scan_batch = null;
/* 582 */       scan_nextBatch();
/* 583 */     }
/* 584 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 585 */     scan_scanTime1 = 0;
/* 586 */   }
/* 587 */ }
