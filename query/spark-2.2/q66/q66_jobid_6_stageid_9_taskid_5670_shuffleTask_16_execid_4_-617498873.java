/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private double agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private double agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private double agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private double agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private double agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private double agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private double agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private double agg_bufValue13;
/* 037 */   private boolean agg_bufIsNull14;
/* 038 */   private double agg_bufValue14;
/* 039 */   private boolean agg_bufIsNull15;
/* 040 */   private double agg_bufValue15;
/* 041 */   private boolean agg_bufIsNull16;
/* 042 */   private double agg_bufValue16;
/* 043 */   private boolean agg_bufIsNull17;
/* 044 */   private double agg_bufValue17;
/* 045 */   private boolean agg_bufIsNull18;
/* 046 */   private double agg_bufValue18;
/* 047 */   private boolean agg_bufIsNull19;
/* 048 */   private double agg_bufValue19;
/* 049 */   private boolean agg_bufIsNull20;
/* 050 */   private double agg_bufValue20;
/* 051 */   private boolean agg_bufIsNull21;
/* 052 */   private double agg_bufValue21;
/* 053 */   private boolean agg_bufIsNull22;
/* 054 */   private double agg_bufValue22;
/* 055 */   private boolean agg_bufIsNull23;
/* 056 */   private double agg_bufValue23;
/* 057 */   private boolean agg_bufIsNull24;
/* 058 */   private double agg_bufValue24;
/* 059 */   private boolean agg_bufIsNull25;
/* 060 */   private double agg_bufValue25;
/* 061 */   private boolean agg_bufIsNull26;
/* 062 */   private double agg_bufValue26;
/* 063 */   private boolean agg_bufIsNull27;
/* 064 */   private double agg_bufValue27;
/* 065 */   private boolean agg_bufIsNull28;
/* 066 */   private double agg_bufValue28;
/* 067 */   private boolean agg_bufIsNull29;
/* 068 */   private double agg_bufValue29;
/* 069 */   private boolean agg_bufIsNull30;
/* 070 */   private double agg_bufValue30;
/* 071 */   private boolean agg_bufIsNull31;
/* 072 */   private double agg_bufValue31;
/* 073 */   private boolean agg_bufIsNull32;
/* 074 */   private double agg_bufValue32;
/* 075 */   private boolean agg_bufIsNull33;
/* 076 */   private double agg_bufValue33;
/* 077 */   private boolean agg_bufIsNull34;
/* 078 */   private double agg_bufValue34;
/* 079 */   private boolean agg_bufIsNull35;
/* 080 */   private double agg_bufValue35;
/* 081 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 082 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 083 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 084 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 085 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 086 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 087 */   private scala.collection.Iterator inputadapter_input;
/* 088 */   private UnsafeRow agg_result;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 090 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 091 */   private int agg_value88;
/* 092 */   private UnsafeRow agg_result1;
/* 093 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 094 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 095 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 096 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 097 */
/* 098 */   public GeneratedIterator(Object[] references) {
/* 099 */     this.references = references;
/* 100 */   }
/* 101 */
/* 102 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 103 */     partitionIndex = index;
/* 104 */     this.inputs = inputs;
/* 105 */     agg_initAgg = false;
/* 106 */
/* 107 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 108 */
/* 109 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 110 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 111 */     inputadapter_input = inputs[0];
/* 112 */     agg_result = new UnsafeRow(8);
/* 113 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 192);
/* 114 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 115 */
/* 116 */     agg_result1 = new UnsafeRow(44);
/* 117 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 192);
/* 118 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 44);
/* 119 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 120 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 121 */
/* 122 */   }
/* 123 */
/* 124 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 125 */     agg_hashMap = agg_plan.createHashMap();
/* 126 */
/* 127 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 128 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 129 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 130 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 131 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 132 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 133 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 134 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 135 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 136 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 137 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 138 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 139 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 140 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 141 */       UTF8String inputadapter_value6 = inputadapter_row.getUTF8String(6);
/* 142 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 143 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 144 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 145 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 146 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 147 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 148 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 149 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 150 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 151 */       double inputadapter_value11 = inputadapter_isNull11 ? -1.0 : (inputadapter_row.getDouble(11));
/* 152 */       boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 153 */       double inputadapter_value12 = inputadapter_isNull12 ? -1.0 : (inputadapter_row.getDouble(12));
/* 154 */       boolean inputadapter_isNull13 = inputadapter_row.isNullAt(13);
/* 155 */       double inputadapter_value13 = inputadapter_isNull13 ? -1.0 : (inputadapter_row.getDouble(13));
/* 156 */       boolean inputadapter_isNull14 = inputadapter_row.isNullAt(14);
/* 157 */       double inputadapter_value14 = inputadapter_isNull14 ? -1.0 : (inputadapter_row.getDouble(14));
/* 158 */       boolean inputadapter_isNull15 = inputadapter_row.isNullAt(15);
/* 159 */       double inputadapter_value15 = inputadapter_isNull15 ? -1.0 : (inputadapter_row.getDouble(15));
/* 160 */       boolean inputadapter_isNull16 = inputadapter_row.isNullAt(16);
/* 161 */       double inputadapter_value16 = inputadapter_isNull16 ? -1.0 : (inputadapter_row.getDouble(16));
/* 162 */       boolean inputadapter_isNull17 = inputadapter_row.isNullAt(17);
/* 163 */       double inputadapter_value17 = inputadapter_isNull17 ? -1.0 : (inputadapter_row.getDouble(17));
/* 164 */       boolean inputadapter_isNull18 = inputadapter_row.isNullAt(18);
/* 165 */       double inputadapter_value18 = inputadapter_isNull18 ? -1.0 : (inputadapter_row.getDouble(18));
/* 166 */       boolean inputadapter_isNull19 = inputadapter_row.isNullAt(19);
/* 167 */       double inputadapter_value19 = inputadapter_isNull19 ? -1.0 : (inputadapter_row.getDouble(19));
/* 168 */       boolean inputadapter_isNull20 = inputadapter_row.isNullAt(20);
/* 169 */       double inputadapter_value20 = inputadapter_isNull20 ? -1.0 : (inputadapter_row.getDouble(20));
/* 170 */       boolean inputadapter_isNull21 = inputadapter_row.isNullAt(21);
/* 171 */       double inputadapter_value21 = inputadapter_isNull21 ? -1.0 : (inputadapter_row.getDouble(21));
/* 172 */       boolean inputadapter_isNull22 = inputadapter_row.isNullAt(22);
/* 173 */       double inputadapter_value22 = inputadapter_isNull22 ? -1.0 : (inputadapter_row.getDouble(22));
/* 174 */       boolean inputadapter_isNull23 = inputadapter_row.isNullAt(23);
/* 175 */       double inputadapter_value23 = inputadapter_isNull23 ? -1.0 : (inputadapter_row.getDouble(23));
/* 176 */       boolean inputadapter_isNull24 = inputadapter_row.isNullAt(24);
/* 177 */       double inputadapter_value24 = inputadapter_isNull24 ? -1.0 : (inputadapter_row.getDouble(24));
/* 178 */       boolean inputadapter_isNull25 = inputadapter_row.isNullAt(25);
/* 179 */       double inputadapter_value25 = inputadapter_isNull25 ? -1.0 : (inputadapter_row.getDouble(25));
/* 180 */       boolean inputadapter_isNull26 = inputadapter_row.isNullAt(26);
/* 181 */       double inputadapter_value26 = inputadapter_isNull26 ? -1.0 : (inputadapter_row.getDouble(26));
/* 182 */       boolean inputadapter_isNull27 = inputadapter_row.isNullAt(27);
/* 183 */       double inputadapter_value27 = inputadapter_isNull27 ? -1.0 : (inputadapter_row.getDouble(27));
/* 184 */       boolean inputadapter_isNull28 = inputadapter_row.isNullAt(28);
/* 185 */       double inputadapter_value28 = inputadapter_isNull28 ? -1.0 : (inputadapter_row.getDouble(28));
/* 186 */       boolean inputadapter_isNull29 = inputadapter_row.isNullAt(29);
/* 187 */       double inputadapter_value29 = inputadapter_isNull29 ? -1.0 : (inputadapter_row.getDouble(29));
/* 188 */       boolean inputadapter_isNull30 = inputadapter_row.isNullAt(30);
/* 189 */       double inputadapter_value30 = inputadapter_isNull30 ? -1.0 : (inputadapter_row.getDouble(30));
/* 190 */       boolean inputadapter_isNull31 = inputadapter_row.isNullAt(31);
/* 191 */       double inputadapter_value31 = inputadapter_isNull31 ? -1.0 : (inputadapter_row.getDouble(31));
/* 192 */       boolean inputadapter_isNull32 = inputadapter_row.isNullAt(32);
/* 193 */       double inputadapter_value32 = inputadapter_isNull32 ? -1.0 : (inputadapter_row.getDouble(32));
/* 194 */       boolean inputadapter_isNull33 = inputadapter_row.isNullAt(33);
/* 195 */       double inputadapter_value33 = inputadapter_isNull33 ? -1.0 : (inputadapter_row.getDouble(33));
/* 196 */       boolean inputadapter_isNull34 = inputadapter_row.isNullAt(34);
/* 197 */       double inputadapter_value34 = inputadapter_isNull34 ? -1.0 : (inputadapter_row.getDouble(34));
/* 198 */       boolean inputadapter_isNull35 = inputadapter_row.isNullAt(35);
/* 199 */       double inputadapter_value35 = inputadapter_isNull35 ? -1.0 : (inputadapter_row.getDouble(35));
/* 200 */       boolean inputadapter_isNull36 = inputadapter_row.isNullAt(36);
/* 201 */       double inputadapter_value36 = inputadapter_isNull36 ? -1.0 : (inputadapter_row.getDouble(36));
/* 202 */       boolean inputadapter_isNull37 = inputadapter_row.isNullAt(37);
/* 203 */       double inputadapter_value37 = inputadapter_isNull37 ? -1.0 : (inputadapter_row.getDouble(37));
/* 204 */       boolean inputadapter_isNull38 = inputadapter_row.isNullAt(38);
/* 205 */       double inputadapter_value38 = inputadapter_isNull38 ? -1.0 : (inputadapter_row.getDouble(38));
/* 206 */       boolean inputadapter_isNull39 = inputadapter_row.isNullAt(39);
/* 207 */       double inputadapter_value39 = inputadapter_isNull39 ? -1.0 : (inputadapter_row.getDouble(39));
/* 208 */       boolean inputadapter_isNull40 = inputadapter_row.isNullAt(40);
/* 209 */       double inputadapter_value40 = inputadapter_isNull40 ? -1.0 : (inputadapter_row.getDouble(40));
/* 210 */       boolean inputadapter_isNull41 = inputadapter_row.isNullAt(41);
/* 211 */       double inputadapter_value41 = inputadapter_isNull41 ? -1.0 : (inputadapter_row.getDouble(41));
/* 212 */       boolean inputadapter_isNull42 = inputadapter_row.isNullAt(42);
/* 213 */       double inputadapter_value42 = inputadapter_isNull42 ? -1.0 : (inputadapter_row.getDouble(42));
/* 214 */       boolean inputadapter_isNull43 = inputadapter_row.isNullAt(43);
/* 215 */       double inputadapter_value43 = inputadapter_isNull43 ? -1.0 : (inputadapter_row.getDouble(43));
/* 216 */
/* 217 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 218 */
/* 219 */       UnsafeRow agg_fastAggBuffer = null;
/* 220 */
/* 221 */       if (agg_fastAggBuffer == null) {
/* 222 */         // generate grouping key
/* 223 */         agg_holder.reset();
/* 224 */
/* 225 */         agg_rowWriter.zeroOutNullBytes();
/* 226 */
/* 227 */         if (inputadapter_isNull) {
/* 228 */           agg_rowWriter.setNullAt(0);
/* 229 */         } else {
/* 230 */           agg_rowWriter.write(0, inputadapter_value);
/* 231 */         }
/* 232 */
/* 233 */         if (inputadapter_isNull1) {
/* 234 */           agg_rowWriter.setNullAt(1);
/* 235 */         } else {
/* 236 */           agg_rowWriter.write(1, inputadapter_value1);
/* 237 */         }
/* 238 */
/* 239 */         if (inputadapter_isNull2) {
/* 240 */           agg_rowWriter.setNullAt(2);
/* 241 */         } else {
/* 242 */           agg_rowWriter.write(2, inputadapter_value2);
/* 243 */         }
/* 244 */
/* 245 */         if (inputadapter_isNull3) {
/* 246 */           agg_rowWriter.setNullAt(3);
/* 247 */         } else {
/* 248 */           agg_rowWriter.write(3, inputadapter_value3);
/* 249 */         }
/* 250 */
/* 251 */         if (inputadapter_isNull4) {
/* 252 */           agg_rowWriter.setNullAt(4);
/* 253 */         } else {
/* 254 */           agg_rowWriter.write(4, inputadapter_value4);
/* 255 */         }
/* 256 */
/* 257 */         if (inputadapter_isNull5) {
/* 258 */           agg_rowWriter.setNullAt(5);
/* 259 */         } else {
/* 260 */           agg_rowWriter.write(5, inputadapter_value5);
/* 261 */         }
/* 262 */
/* 263 */         agg_rowWriter.write(6, inputadapter_value6);
/* 264 */
/* 265 */         if (inputadapter_isNull7) {
/* 266 */           agg_rowWriter.setNullAt(7);
/* 267 */         } else {
/* 268 */           agg_rowWriter.write(7, inputadapter_value7);
/* 269 */         }
/* 270 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 271 */         agg_value88 = 42;
/* 272 */
/* 273 */         if (!inputadapter_isNull) {
/* 274 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value88);
/* 275 */         }
/* 276 */
/* 277 */         if (!inputadapter_isNull1) {
/* 278 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value88);
/* 279 */         }
/* 280 */
/* 281 */         if (!inputadapter_isNull2) {
/* 282 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value88);
/* 283 */         }
/* 284 */
/* 285 */         if (!inputadapter_isNull3) {
/* 286 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value88);
/* 287 */         }
/* 288 */
/* 289 */         if (!inputadapter_isNull4) {
/* 290 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value88);
/* 291 */         }
/* 292 */
/* 293 */         if (!inputadapter_isNull5) {
/* 294 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value88);
/* 295 */         }
/* 296 */
/* 297 */         agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value6.getBaseObject(), inputadapter_value6.getBaseOffset(), inputadapter_value6.numBytes(), agg_value88);
/* 298 */
/* 299 */         if (!inputadapter_isNull7) {
/* 300 */           agg_value88 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value7, agg_value88);
/* 301 */         }
/* 302 */         if (true) {
/* 303 */           // try to get the buffer from hash map
/* 304 */           agg_unsafeRowAggBuffer =
/* 305 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value88);
/* 306 */         }
/* 307 */         if (agg_unsafeRowAggBuffer == null) {
/* 308 */           if (agg_sorter == null) {
/* 309 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 310 */           } else {
/* 311 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 312 */           }
/* 313 */
/* 314 */           // the hash map had be spilled, it should have enough memory now,
/* 315 */           // try  to allocate buffer again.
/* 316 */           agg_unsafeRowAggBuffer =
/* 317 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value88);
/* 318 */           if (agg_unsafeRowAggBuffer == null) {
/* 319 */             // failed to allocate the first page
/* 320 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 321 */           }
/* 322 */         }
/* 323 */       }
/* 324 */
/* 325 */       if (agg_fastAggBuffer != null) {
/* 326 */         // update fast row
/* 327 */
/* 328 */       } else {
/* 329 */         // update unsafe row
/* 330 */
/* 331 */         // common sub-expressions
/* 332 */
/* 333 */         // evaluate aggregate function
/* 334 */         boolean agg_isNull62 = true;
/* 335 */         double agg_value98 = -1.0;
/* 336 */
/* 337 */         boolean agg_isNull64 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 338 */         double agg_value100 = agg_isNull64 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 339 */         boolean agg_isNull63 = agg_isNull64;
/* 340 */         double agg_value99 = agg_value100;
/* 341 */         if (agg_isNull63) {
/* 342 */           boolean agg_isNull65 = false;
/* 343 */           double agg_value101 = -1.0;
/* 344 */           if (!false) {
/* 345 */             agg_value101 = (double) 0;
/* 346 */           }
/* 347 */           if (!agg_isNull65) {
/* 348 */             agg_isNull63 = false;
/* 349 */             agg_value99 = agg_value101;
/* 350 */           }
/* 351 */         }
/* 352 */
/* 353 */         if (!inputadapter_isNull8) {
/* 354 */           agg_isNull62 = false; // resultCode could change nullability.
/* 355 */           agg_value98 = agg_value99 + inputadapter_value8;
/* 356 */
/* 357 */         }
/* 358 */         boolean agg_isNull61 = agg_isNull62;
/* 359 */         double agg_value97 = agg_value98;
/* 360 */         if (agg_isNull61) {
/* 361 */           boolean agg_isNull68 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 362 */           double agg_value104 = agg_isNull68 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 363 */           if (!agg_isNull68) {
/* 364 */             agg_isNull61 = false;
/* 365 */             agg_value97 = agg_value104;
/* 366 */           }
/* 367 */         }
/* 368 */         boolean agg_isNull70 = true;
/* 369 */         double agg_value106 = -1.0;
/* 370 */
/* 371 */         boolean agg_isNull72 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 372 */         double agg_value108 = agg_isNull72 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 373 */         boolean agg_isNull71 = agg_isNull72;
/* 374 */         double agg_value107 = agg_value108;
/* 375 */         if (agg_isNull71) {
/* 376 */           boolean agg_isNull73 = false;
/* 377 */           double agg_value109 = -1.0;
/* 378 */           if (!false) {
/* 379 */             agg_value109 = (double) 0;
/* 380 */           }
/* 381 */           if (!agg_isNull73) {
/* 382 */             agg_isNull71 = false;
/* 383 */             agg_value107 = agg_value109;
/* 384 */           }
/* 385 */         }
/* 386 */
/* 387 */         if (!inputadapter_isNull9) {
/* 388 */           agg_isNull70 = false; // resultCode could change nullability.
/* 389 */           agg_value106 = agg_value107 + inputadapter_value9;
/* 390 */
/* 391 */         }
/* 392 */         boolean agg_isNull69 = agg_isNull70;
/* 393 */         double agg_value105 = agg_value106;
/* 394 */         if (agg_isNull69) {
/* 395 */           boolean agg_isNull76 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 396 */           double agg_value112 = agg_isNull76 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 397 */           if (!agg_isNull76) {
/* 398 */             agg_isNull69 = false;
/* 399 */             agg_value105 = agg_value112;
/* 400 */           }
/* 401 */         }
/* 402 */         boolean agg_isNull78 = true;
/* 403 */         double agg_value114 = -1.0;
/* 404 */
/* 405 */         boolean agg_isNull80 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 406 */         double agg_value116 = agg_isNull80 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 407 */         boolean agg_isNull79 = agg_isNull80;
/* 408 */         double agg_value115 = agg_value116;
/* 409 */         if (agg_isNull79) {
/* 410 */           boolean agg_isNull81 = false;
/* 411 */           double agg_value117 = -1.0;
/* 412 */           if (!false) {
/* 413 */             agg_value117 = (double) 0;
/* 414 */           }
/* 415 */           if (!agg_isNull81) {
/* 416 */             agg_isNull79 = false;
/* 417 */             agg_value115 = agg_value117;
/* 418 */           }
/* 419 */         }
/* 420 */
/* 421 */         if (!inputadapter_isNull10) {
/* 422 */           agg_isNull78 = false; // resultCode could change nullability.
/* 423 */           agg_value114 = agg_value115 + inputadapter_value10;
/* 424 */
/* 425 */         }
/* 426 */         boolean agg_isNull77 = agg_isNull78;
/* 427 */         double agg_value113 = agg_value114;
/* 428 */         if (agg_isNull77) {
/* 429 */           boolean agg_isNull84 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 430 */           double agg_value120 = agg_isNull84 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 431 */           if (!agg_isNull84) {
/* 432 */             agg_isNull77 = false;
/* 433 */             agg_value113 = agg_value120;
/* 434 */           }
/* 435 */         }
/* 436 */         boolean agg_isNull86 = true;
/* 437 */         double agg_value122 = -1.0;
/* 438 */
/* 439 */         boolean agg_isNull88 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 440 */         double agg_value124 = agg_isNull88 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 441 */         boolean agg_isNull87 = agg_isNull88;
/* 442 */         double agg_value123 = agg_value124;
/* 443 */         if (agg_isNull87) {
/* 444 */           boolean agg_isNull89 = false;
/* 445 */           double agg_value125 = -1.0;
/* 446 */           if (!false) {
/* 447 */             agg_value125 = (double) 0;
/* 448 */           }
/* 449 */           if (!agg_isNull89) {
/* 450 */             agg_isNull87 = false;
/* 451 */             agg_value123 = agg_value125;
/* 452 */           }
/* 453 */         }
/* 454 */
/* 455 */         if (!inputadapter_isNull11) {
/* 456 */           agg_isNull86 = false; // resultCode could change nullability.
/* 457 */           agg_value122 = agg_value123 + inputadapter_value11;
/* 458 */
/* 459 */         }
/* 460 */         boolean agg_isNull85 = agg_isNull86;
/* 461 */         double agg_value121 = agg_value122;
/* 462 */         if (agg_isNull85) {
/* 463 */           boolean agg_isNull92 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 464 */           double agg_value128 = agg_isNull92 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 465 */           if (!agg_isNull92) {
/* 466 */             agg_isNull85 = false;
/* 467 */             agg_value121 = agg_value128;
/* 468 */           }
/* 469 */         }
/* 470 */         boolean agg_isNull94 = true;
/* 471 */         double agg_value130 = -1.0;
/* 472 */
/* 473 */         boolean agg_isNull96 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 474 */         double agg_value132 = agg_isNull96 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 475 */         boolean agg_isNull95 = agg_isNull96;
/* 476 */         double agg_value131 = agg_value132;
/* 477 */         if (agg_isNull95) {
/* 478 */           boolean agg_isNull97 = false;
/* 479 */           double agg_value133 = -1.0;
/* 480 */           if (!false) {
/* 481 */             agg_value133 = (double) 0;
/* 482 */           }
/* 483 */           if (!agg_isNull97) {
/* 484 */             agg_isNull95 = false;
/* 485 */             agg_value131 = agg_value133;
/* 486 */           }
/* 487 */         }
/* 488 */
/* 489 */         if (!inputadapter_isNull12) {
/* 490 */           agg_isNull94 = false; // resultCode could change nullability.
/* 491 */           agg_value130 = agg_value131 + inputadapter_value12;
/* 492 */
/* 493 */         }
/* 494 */         boolean agg_isNull93 = agg_isNull94;
/* 495 */         double agg_value129 = agg_value130;
/* 496 */         if (agg_isNull93) {
/* 497 */           boolean agg_isNull100 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 498 */           double agg_value136 = agg_isNull100 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 499 */           if (!agg_isNull100) {
/* 500 */             agg_isNull93 = false;
/* 501 */             agg_value129 = agg_value136;
/* 502 */           }
/* 503 */         }
/* 504 */         boolean agg_isNull102 = true;
/* 505 */         double agg_value138 = -1.0;
/* 506 */
/* 507 */         boolean agg_isNull104 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 508 */         double agg_value140 = agg_isNull104 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 509 */         boolean agg_isNull103 = agg_isNull104;
/* 510 */         double agg_value139 = agg_value140;
/* 511 */         if (agg_isNull103) {
/* 512 */           boolean agg_isNull105 = false;
/* 513 */           double agg_value141 = -1.0;
/* 514 */           if (!false) {
/* 515 */             agg_value141 = (double) 0;
/* 516 */           }
/* 517 */           if (!agg_isNull105) {
/* 518 */             agg_isNull103 = false;
/* 519 */             agg_value139 = agg_value141;
/* 520 */           }
/* 521 */         }
/* 522 */
/* 523 */         if (!inputadapter_isNull13) {
/* 524 */           agg_isNull102 = false; // resultCode could change nullability.
/* 525 */           agg_value138 = agg_value139 + inputadapter_value13;
/* 526 */
/* 527 */         }
/* 528 */         boolean agg_isNull101 = agg_isNull102;
/* 529 */         double agg_value137 = agg_value138;
/* 530 */         if (agg_isNull101) {
/* 531 */           boolean agg_isNull108 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 532 */           double agg_value144 = agg_isNull108 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 533 */           if (!agg_isNull108) {
/* 534 */             agg_isNull101 = false;
/* 535 */             agg_value137 = agg_value144;
/* 536 */           }
/* 537 */         }
/* 538 */         boolean agg_isNull110 = true;
/* 539 */         double agg_value146 = -1.0;
/* 540 */
/* 541 */         boolean agg_isNull112 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 542 */         double agg_value148 = agg_isNull112 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 543 */         boolean agg_isNull111 = agg_isNull112;
/* 544 */         double agg_value147 = agg_value148;
/* 545 */         if (agg_isNull111) {
/* 546 */           boolean agg_isNull113 = false;
/* 547 */           double agg_value149 = -1.0;
/* 548 */           if (!false) {
/* 549 */             agg_value149 = (double) 0;
/* 550 */           }
/* 551 */           if (!agg_isNull113) {
/* 552 */             agg_isNull111 = false;
/* 553 */             agg_value147 = agg_value149;
/* 554 */           }
/* 555 */         }
/* 556 */
/* 557 */         if (!inputadapter_isNull14) {
/* 558 */           agg_isNull110 = false; // resultCode could change nullability.
/* 559 */           agg_value146 = agg_value147 + inputadapter_value14;
/* 560 */
/* 561 */         }
/* 562 */         boolean agg_isNull109 = agg_isNull110;
/* 563 */         double agg_value145 = agg_value146;
/* 564 */         if (agg_isNull109) {
/* 565 */           boolean agg_isNull116 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 566 */           double agg_value152 = agg_isNull116 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 567 */           if (!agg_isNull116) {
/* 568 */             agg_isNull109 = false;
/* 569 */             agg_value145 = agg_value152;
/* 570 */           }
/* 571 */         }
/* 572 */         boolean agg_isNull118 = true;
/* 573 */         double agg_value154 = -1.0;
/* 574 */
/* 575 */         boolean agg_isNull120 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 576 */         double agg_value156 = agg_isNull120 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 577 */         boolean agg_isNull119 = agg_isNull120;
/* 578 */         double agg_value155 = agg_value156;
/* 579 */         if (agg_isNull119) {
/* 580 */           boolean agg_isNull121 = false;
/* 581 */           double agg_value157 = -1.0;
/* 582 */           if (!false) {
/* 583 */             agg_value157 = (double) 0;
/* 584 */           }
/* 585 */           if (!agg_isNull121) {
/* 586 */             agg_isNull119 = false;
/* 587 */             agg_value155 = agg_value157;
/* 588 */           }
/* 589 */         }
/* 590 */
/* 591 */         if (!inputadapter_isNull15) {
/* 592 */           agg_isNull118 = false; // resultCode could change nullability.
/* 593 */           agg_value154 = agg_value155 + inputadapter_value15;
/* 594 */
/* 595 */         }
/* 596 */         boolean agg_isNull117 = agg_isNull118;
/* 597 */         double agg_value153 = agg_value154;
/* 598 */         if (agg_isNull117) {
/* 599 */           boolean agg_isNull124 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 600 */           double agg_value160 = agg_isNull124 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 601 */           if (!agg_isNull124) {
/* 602 */             agg_isNull117 = false;
/* 603 */             agg_value153 = agg_value160;
/* 604 */           }
/* 605 */         }
/* 606 */         boolean agg_isNull126 = true;
/* 607 */         double agg_value162 = -1.0;
/* 608 */
/* 609 */         boolean agg_isNull128 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 610 */         double agg_value164 = agg_isNull128 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 611 */         boolean agg_isNull127 = agg_isNull128;
/* 612 */         double agg_value163 = agg_value164;
/* 613 */         if (agg_isNull127) {
/* 614 */           boolean agg_isNull129 = false;
/* 615 */           double agg_value165 = -1.0;
/* 616 */           if (!false) {
/* 617 */             agg_value165 = (double) 0;
/* 618 */           }
/* 619 */           if (!agg_isNull129) {
/* 620 */             agg_isNull127 = false;
/* 621 */             agg_value163 = agg_value165;
/* 622 */           }
/* 623 */         }
/* 624 */
/* 625 */         if (!inputadapter_isNull16) {
/* 626 */           agg_isNull126 = false; // resultCode could change nullability.
/* 627 */           agg_value162 = agg_value163 + inputadapter_value16;
/* 628 */
/* 629 */         }
/* 630 */         boolean agg_isNull125 = agg_isNull126;
/* 631 */         double agg_value161 = agg_value162;
/* 632 */         if (agg_isNull125) {
/* 633 */           boolean agg_isNull132 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 634 */           double agg_value168 = agg_isNull132 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 635 */           if (!agg_isNull132) {
/* 636 */             agg_isNull125 = false;
/* 637 */             agg_value161 = agg_value168;
/* 638 */           }
/* 639 */         }
/* 640 */         boolean agg_isNull134 = true;
/* 641 */         double agg_value170 = -1.0;
/* 642 */
/* 643 */         boolean agg_isNull136 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 644 */         double agg_value172 = agg_isNull136 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 645 */         boolean agg_isNull135 = agg_isNull136;
/* 646 */         double agg_value171 = agg_value172;
/* 647 */         if (agg_isNull135) {
/* 648 */           boolean agg_isNull137 = false;
/* 649 */           double agg_value173 = -1.0;
/* 650 */           if (!false) {
/* 651 */             agg_value173 = (double) 0;
/* 652 */           }
/* 653 */           if (!agg_isNull137) {
/* 654 */             agg_isNull135 = false;
/* 655 */             agg_value171 = agg_value173;
/* 656 */           }
/* 657 */         }
/* 658 */
/* 659 */         if (!inputadapter_isNull17) {
/* 660 */           agg_isNull134 = false; // resultCode could change nullability.
/* 661 */           agg_value170 = agg_value171 + inputadapter_value17;
/* 662 */
/* 663 */         }
/* 664 */         boolean agg_isNull133 = agg_isNull134;
/* 665 */         double agg_value169 = agg_value170;
/* 666 */         if (agg_isNull133) {
/* 667 */           boolean agg_isNull140 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 668 */           double agg_value176 = agg_isNull140 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 669 */           if (!agg_isNull140) {
/* 670 */             agg_isNull133 = false;
/* 671 */             agg_value169 = agg_value176;
/* 672 */           }
/* 673 */         }
/* 674 */         boolean agg_isNull142 = true;
/* 675 */         double agg_value178 = -1.0;
/* 676 */
/* 677 */         boolean agg_isNull144 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 678 */         double agg_value180 = agg_isNull144 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 679 */         boolean agg_isNull143 = agg_isNull144;
/* 680 */         double agg_value179 = agg_value180;
/* 681 */         if (agg_isNull143) {
/* 682 */           boolean agg_isNull145 = false;
/* 683 */           double agg_value181 = -1.0;
/* 684 */           if (!false) {
/* 685 */             agg_value181 = (double) 0;
/* 686 */           }
/* 687 */           if (!agg_isNull145) {
/* 688 */             agg_isNull143 = false;
/* 689 */             agg_value179 = agg_value181;
/* 690 */           }
/* 691 */         }
/* 692 */
/* 693 */         if (!inputadapter_isNull18) {
/* 694 */           agg_isNull142 = false; // resultCode could change nullability.
/* 695 */           agg_value178 = agg_value179 + inputadapter_value18;
/* 696 */
/* 697 */         }
/* 698 */         boolean agg_isNull141 = agg_isNull142;
/* 699 */         double agg_value177 = agg_value178;
/* 700 */         if (agg_isNull141) {
/* 701 */           boolean agg_isNull148 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 702 */           double agg_value184 = agg_isNull148 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 703 */           if (!agg_isNull148) {
/* 704 */             agg_isNull141 = false;
/* 705 */             agg_value177 = agg_value184;
/* 706 */           }
/* 707 */         }
/* 708 */         boolean agg_isNull150 = true;
/* 709 */         double agg_value186 = -1.0;
/* 710 */
/* 711 */         boolean agg_isNull152 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 712 */         double agg_value188 = agg_isNull152 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 713 */         boolean agg_isNull151 = agg_isNull152;
/* 714 */         double agg_value187 = agg_value188;
/* 715 */         if (agg_isNull151) {
/* 716 */           boolean agg_isNull153 = false;
/* 717 */           double agg_value189 = -1.0;
/* 718 */           if (!false) {
/* 719 */             agg_value189 = (double) 0;
/* 720 */           }
/* 721 */           if (!agg_isNull153) {
/* 722 */             agg_isNull151 = false;
/* 723 */             agg_value187 = agg_value189;
/* 724 */           }
/* 725 */         }
/* 726 */
/* 727 */         if (!inputadapter_isNull19) {
/* 728 */           agg_isNull150 = false; // resultCode could change nullability.
/* 729 */           agg_value186 = agg_value187 + inputadapter_value19;
/* 730 */
/* 731 */         }
/* 732 */         boolean agg_isNull149 = agg_isNull150;
/* 733 */         double agg_value185 = agg_value186;
/* 734 */         if (agg_isNull149) {
/* 735 */           boolean agg_isNull156 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 736 */           double agg_value192 = agg_isNull156 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 737 */           if (!agg_isNull156) {
/* 738 */             agg_isNull149 = false;
/* 739 */             agg_value185 = agg_value192;
/* 740 */           }
/* 741 */         }
/* 742 */         boolean agg_isNull158 = true;
/* 743 */         double agg_value194 = -1.0;
/* 744 */
/* 745 */         boolean agg_isNull160 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 746 */         double agg_value196 = agg_isNull160 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 747 */         boolean agg_isNull159 = agg_isNull160;
/* 748 */         double agg_value195 = agg_value196;
/* 749 */         if (agg_isNull159) {
/* 750 */           boolean agg_isNull161 = false;
/* 751 */           double agg_value197 = -1.0;
/* 752 */           if (!false) {
/* 753 */             agg_value197 = (double) 0;
/* 754 */           }
/* 755 */           if (!agg_isNull161) {
/* 756 */             agg_isNull159 = false;
/* 757 */             agg_value195 = agg_value197;
/* 758 */           }
/* 759 */         }
/* 760 */
/* 761 */         if (!inputadapter_isNull20) {
/* 762 */           agg_isNull158 = false; // resultCode could change nullability.
/* 763 */           agg_value194 = agg_value195 + inputadapter_value20;
/* 764 */
/* 765 */         }
/* 766 */         boolean agg_isNull157 = agg_isNull158;
/* 767 */         double agg_value193 = agg_value194;
/* 768 */         if (agg_isNull157) {
/* 769 */           boolean agg_isNull164 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 770 */           double agg_value200 = agg_isNull164 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 771 */           if (!agg_isNull164) {
/* 772 */             agg_isNull157 = false;
/* 773 */             agg_value193 = agg_value200;
/* 774 */           }
/* 775 */         }
/* 776 */         boolean agg_isNull166 = true;
/* 777 */         double agg_value202 = -1.0;
/* 778 */
/* 779 */         boolean agg_isNull168 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 780 */         double agg_value204 = agg_isNull168 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 781 */         boolean agg_isNull167 = agg_isNull168;
/* 782 */         double agg_value203 = agg_value204;
/* 783 */         if (agg_isNull167) {
/* 784 */           boolean agg_isNull169 = false;
/* 785 */           double agg_value205 = -1.0;
/* 786 */           if (!false) {
/* 787 */             agg_value205 = (double) 0;
/* 788 */           }
/* 789 */           if (!agg_isNull169) {
/* 790 */             agg_isNull167 = false;
/* 791 */             agg_value203 = agg_value205;
/* 792 */           }
/* 793 */         }
/* 794 */
/* 795 */         if (!inputadapter_isNull21) {
/* 796 */           agg_isNull166 = false; // resultCode could change nullability.
/* 797 */           agg_value202 = agg_value203 + inputadapter_value21;
/* 798 */
/* 799 */         }
/* 800 */         boolean agg_isNull165 = agg_isNull166;
/* 801 */         double agg_value201 = agg_value202;
/* 802 */         if (agg_isNull165) {
/* 803 */           boolean agg_isNull172 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 804 */           double agg_value208 = agg_isNull172 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 805 */           if (!agg_isNull172) {
/* 806 */             agg_isNull165 = false;
/* 807 */             agg_value201 = agg_value208;
/* 808 */           }
/* 809 */         }
/* 810 */         boolean agg_isNull174 = true;
/* 811 */         double agg_value210 = -1.0;
/* 812 */
/* 813 */         boolean agg_isNull176 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 814 */         double agg_value212 = agg_isNull176 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 815 */         boolean agg_isNull175 = agg_isNull176;
/* 816 */         double agg_value211 = agg_value212;
/* 817 */         if (agg_isNull175) {
/* 818 */           boolean agg_isNull177 = false;
/* 819 */           double agg_value213 = -1.0;
/* 820 */           if (!false) {
/* 821 */             agg_value213 = (double) 0;
/* 822 */           }
/* 823 */           if (!agg_isNull177) {
/* 824 */             agg_isNull175 = false;
/* 825 */             agg_value211 = agg_value213;
/* 826 */           }
/* 827 */         }
/* 828 */
/* 829 */         if (!inputadapter_isNull22) {
/* 830 */           agg_isNull174 = false; // resultCode could change nullability.
/* 831 */           agg_value210 = agg_value211 + inputadapter_value22;
/* 832 */
/* 833 */         }
/* 834 */         boolean agg_isNull173 = agg_isNull174;
/* 835 */         double agg_value209 = agg_value210;
/* 836 */         if (agg_isNull173) {
/* 837 */           boolean agg_isNull180 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 838 */           double agg_value216 = agg_isNull180 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 839 */           if (!agg_isNull180) {
/* 840 */             agg_isNull173 = false;
/* 841 */             agg_value209 = agg_value216;
/* 842 */           }
/* 843 */         }
/* 844 */         boolean agg_isNull182 = true;
/* 845 */         double agg_value218 = -1.0;
/* 846 */
/* 847 */         boolean agg_isNull184 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 848 */         double agg_value220 = agg_isNull184 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 849 */         boolean agg_isNull183 = agg_isNull184;
/* 850 */         double agg_value219 = agg_value220;
/* 851 */         if (agg_isNull183) {
/* 852 */           boolean agg_isNull185 = false;
/* 853 */           double agg_value221 = -1.0;
/* 854 */           if (!false) {
/* 855 */             agg_value221 = (double) 0;
/* 856 */           }
/* 857 */           if (!agg_isNull185) {
/* 858 */             agg_isNull183 = false;
/* 859 */             agg_value219 = agg_value221;
/* 860 */           }
/* 861 */         }
/* 862 */
/* 863 */         if (!inputadapter_isNull23) {
/* 864 */           agg_isNull182 = false; // resultCode could change nullability.
/* 865 */           agg_value218 = agg_value219 + inputadapter_value23;
/* 866 */
/* 867 */         }
/* 868 */         boolean agg_isNull181 = agg_isNull182;
/* 869 */         double agg_value217 = agg_value218;
/* 870 */         if (agg_isNull181) {
/* 871 */           boolean agg_isNull188 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 872 */           double agg_value224 = agg_isNull188 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 873 */           if (!agg_isNull188) {
/* 874 */             agg_isNull181 = false;
/* 875 */             agg_value217 = agg_value224;
/* 876 */           }
/* 877 */         }
/* 878 */         boolean agg_isNull190 = true;
/* 879 */         double agg_value226 = -1.0;
/* 880 */
/* 881 */         boolean agg_isNull192 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 882 */         double agg_value228 = agg_isNull192 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 883 */         boolean agg_isNull191 = agg_isNull192;
/* 884 */         double agg_value227 = agg_value228;
/* 885 */         if (agg_isNull191) {
/* 886 */           boolean agg_isNull193 = false;
/* 887 */           double agg_value229 = -1.0;
/* 888 */           if (!false) {
/* 889 */             agg_value229 = (double) 0;
/* 890 */           }
/* 891 */           if (!agg_isNull193) {
/* 892 */             agg_isNull191 = false;
/* 893 */             agg_value227 = agg_value229;
/* 894 */           }
/* 895 */         }
/* 896 */
/* 897 */         if (!inputadapter_isNull24) {
/* 898 */           agg_isNull190 = false; // resultCode could change nullability.
/* 899 */           agg_value226 = agg_value227 + inputadapter_value24;
/* 900 */
/* 901 */         }
/* 902 */         boolean agg_isNull189 = agg_isNull190;
/* 903 */         double agg_value225 = agg_value226;
/* 904 */         if (agg_isNull189) {
/* 905 */           boolean agg_isNull196 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 906 */           double agg_value232 = agg_isNull196 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 907 */           if (!agg_isNull196) {
/* 908 */             agg_isNull189 = false;
/* 909 */             agg_value225 = agg_value232;
/* 910 */           }
/* 911 */         }
/* 912 */         boolean agg_isNull198 = true;
/* 913 */         double agg_value234 = -1.0;
/* 914 */
/* 915 */         boolean agg_isNull200 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 916 */         double agg_value236 = agg_isNull200 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 917 */         boolean agg_isNull199 = agg_isNull200;
/* 918 */         double agg_value235 = agg_value236;
/* 919 */         if (agg_isNull199) {
/* 920 */           boolean agg_isNull201 = false;
/* 921 */           double agg_value237 = -1.0;
/* 922 */           if (!false) {
/* 923 */             agg_value237 = (double) 0;
/* 924 */           }
/* 925 */           if (!agg_isNull201) {
/* 926 */             agg_isNull199 = false;
/* 927 */             agg_value235 = agg_value237;
/* 928 */           }
/* 929 */         }
/* 930 */
/* 931 */         if (!inputadapter_isNull25) {
/* 932 */           agg_isNull198 = false; // resultCode could change nullability.
/* 933 */           agg_value234 = agg_value235 + inputadapter_value25;
/* 934 */
/* 935 */         }
/* 936 */         boolean agg_isNull197 = agg_isNull198;
/* 937 */         double agg_value233 = agg_value234;
/* 938 */         if (agg_isNull197) {
/* 939 */           boolean agg_isNull204 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 940 */           double agg_value240 = agg_isNull204 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 941 */           if (!agg_isNull204) {
/* 942 */             agg_isNull197 = false;
/* 943 */             agg_value233 = agg_value240;
/* 944 */           }
/* 945 */         }
/* 946 */         boolean agg_isNull206 = true;
/* 947 */         double agg_value242 = -1.0;
/* 948 */
/* 949 */         boolean agg_isNull208 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 950 */         double agg_value244 = agg_isNull208 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 951 */         boolean agg_isNull207 = agg_isNull208;
/* 952 */         double agg_value243 = agg_value244;
/* 953 */         if (agg_isNull207) {
/* 954 */           boolean agg_isNull209 = false;
/* 955 */           double agg_value245 = -1.0;
/* 956 */           if (!false) {
/* 957 */             agg_value245 = (double) 0;
/* 958 */           }
/* 959 */           if (!agg_isNull209) {
/* 960 */             agg_isNull207 = false;
/* 961 */             agg_value243 = agg_value245;
/* 962 */           }
/* 963 */         }
/* 964 */
/* 965 */         if (!inputadapter_isNull26) {
/* 966 */           agg_isNull206 = false; // resultCode could change nullability.
/* 967 */           agg_value242 = agg_value243 + inputadapter_value26;
/* 968 */
/* 969 */         }
/* 970 */         boolean agg_isNull205 = agg_isNull206;
/* 971 */         double agg_value241 = agg_value242;
/* 972 */         if (agg_isNull205) {
/* 973 */           boolean agg_isNull212 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 974 */           double agg_value248 = agg_isNull212 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 975 */           if (!agg_isNull212) {
/* 976 */             agg_isNull205 = false;
/* 977 */             agg_value241 = agg_value248;
/* 978 */           }
/* 979 */         }
/* 980 */         boolean agg_isNull214 = true;
/* 981 */         double agg_value250 = -1.0;
/* 982 */
/* 983 */         boolean agg_isNull216 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 984 */         double agg_value252 = agg_isNull216 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 985 */         boolean agg_isNull215 = agg_isNull216;
/* 986 */         double agg_value251 = agg_value252;
/* 987 */         if (agg_isNull215) {
/* 988 */           boolean agg_isNull217 = false;
/* 989 */           double agg_value253 = -1.0;
/* 990 */           if (!false) {
/* 991 */             agg_value253 = (double) 0;
/* 992 */           }
/* 993 */           if (!agg_isNull217) {
/* 994 */             agg_isNull215 = false;
/* 995 */             agg_value251 = agg_value253;
/* 996 */           }
/* 997 */         }
/* 998 */
/* 999 */         if (!inputadapter_isNull27) {
/* 1000 */           agg_isNull214 = false; // resultCode could change nullability.
/* 1001 */           agg_value250 = agg_value251 + inputadapter_value27;
/* 1002 */
/* 1003 */         }
/* 1004 */         boolean agg_isNull213 = agg_isNull214;
/* 1005 */         double agg_value249 = agg_value250;
/* 1006 */         if (agg_isNull213) {
/* 1007 */           boolean agg_isNull220 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 1008 */           double agg_value256 = agg_isNull220 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 1009 */           if (!agg_isNull220) {
/* 1010 */             agg_isNull213 = false;
/* 1011 */             agg_value249 = agg_value256;
/* 1012 */           }
/* 1013 */         }
/* 1014 */         boolean agg_isNull222 = true;
/* 1015 */         double agg_value258 = -1.0;
/* 1016 */
/* 1017 */         boolean agg_isNull224 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 1018 */         double agg_value260 = agg_isNull224 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 1019 */         boolean agg_isNull223 = agg_isNull224;
/* 1020 */         double agg_value259 = agg_value260;
/* 1021 */         if (agg_isNull223) {
/* 1022 */           boolean agg_isNull225 = false;
/* 1023 */           double agg_value261 = -1.0;
/* 1024 */           if (!false) {
/* 1025 */             agg_value261 = (double) 0;
/* 1026 */           }
/* 1027 */           if (!agg_isNull225) {
/* 1028 */             agg_isNull223 = false;
/* 1029 */             agg_value259 = agg_value261;
/* 1030 */           }
/* 1031 */         }
/* 1032 */
/* 1033 */         if (!inputadapter_isNull28) {
/* 1034 */           agg_isNull222 = false; // resultCode could change nullability.
/* 1035 */           agg_value258 = agg_value259 + inputadapter_value28;
/* 1036 */
/* 1037 */         }
/* 1038 */         boolean agg_isNull221 = agg_isNull222;
/* 1039 */         double agg_value257 = agg_value258;
/* 1040 */         if (agg_isNull221) {
/* 1041 */           boolean agg_isNull228 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 1042 */           double agg_value264 = agg_isNull228 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 1043 */           if (!agg_isNull228) {
/* 1044 */             agg_isNull221 = false;
/* 1045 */             agg_value257 = agg_value264;
/* 1046 */           }
/* 1047 */         }
/* 1048 */         boolean agg_isNull230 = true;
/* 1049 */         double agg_value266 = -1.0;
/* 1050 */
/* 1051 */         boolean agg_isNull232 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 1052 */         double agg_value268 = agg_isNull232 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 1053 */         boolean agg_isNull231 = agg_isNull232;
/* 1054 */         double agg_value267 = agg_value268;
/* 1055 */         if (agg_isNull231) {
/* 1056 */           boolean agg_isNull233 = false;
/* 1057 */           double agg_value269 = -1.0;
/* 1058 */           if (!false) {
/* 1059 */             agg_value269 = (double) 0;
/* 1060 */           }
/* 1061 */           if (!agg_isNull233) {
/* 1062 */             agg_isNull231 = false;
/* 1063 */             agg_value267 = agg_value269;
/* 1064 */           }
/* 1065 */         }
/* 1066 */
/* 1067 */         if (!inputadapter_isNull29) {
/* 1068 */           agg_isNull230 = false; // resultCode could change nullability.
/* 1069 */           agg_value266 = agg_value267 + inputadapter_value29;
/* 1070 */
/* 1071 */         }
/* 1072 */         boolean agg_isNull229 = agg_isNull230;
/* 1073 */         double agg_value265 = agg_value266;
/* 1074 */         if (agg_isNull229) {
/* 1075 */           boolean agg_isNull236 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 1076 */           double agg_value272 = agg_isNull236 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 1077 */           if (!agg_isNull236) {
/* 1078 */             agg_isNull229 = false;
/* 1079 */             agg_value265 = agg_value272;
/* 1080 */           }
/* 1081 */         }
/* 1082 */         boolean agg_isNull238 = true;
/* 1083 */         double agg_value274 = -1.0;
/* 1084 */
/* 1085 */         boolean agg_isNull240 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 1086 */         double agg_value276 = agg_isNull240 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 1087 */         boolean agg_isNull239 = agg_isNull240;
/* 1088 */         double agg_value275 = agg_value276;
/* 1089 */         if (agg_isNull239) {
/* 1090 */           boolean agg_isNull241 = false;
/* 1091 */           double agg_value277 = -1.0;
/* 1092 */           if (!false) {
/* 1093 */             agg_value277 = (double) 0;
/* 1094 */           }
/* 1095 */           if (!agg_isNull241) {
/* 1096 */             agg_isNull239 = false;
/* 1097 */             agg_value275 = agg_value277;
/* 1098 */           }
/* 1099 */         }
/* 1100 */
/* 1101 */         if (!inputadapter_isNull30) {
/* 1102 */           agg_isNull238 = false; // resultCode could change nullability.
/* 1103 */           agg_value274 = agg_value275 + inputadapter_value30;
/* 1104 */
/* 1105 */         }
/* 1106 */         boolean agg_isNull237 = agg_isNull238;
/* 1107 */         double agg_value273 = agg_value274;
/* 1108 */         if (agg_isNull237) {
/* 1109 */           boolean agg_isNull244 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 1110 */           double agg_value280 = agg_isNull244 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 1111 */           if (!agg_isNull244) {
/* 1112 */             agg_isNull237 = false;
/* 1113 */             agg_value273 = agg_value280;
/* 1114 */           }
/* 1115 */         }
/* 1116 */         boolean agg_isNull246 = true;
/* 1117 */         double agg_value282 = -1.0;
/* 1118 */
/* 1119 */         boolean agg_isNull248 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 1120 */         double agg_value284 = agg_isNull248 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 1121 */         boolean agg_isNull247 = agg_isNull248;
/* 1122 */         double agg_value283 = agg_value284;
/* 1123 */         if (agg_isNull247) {
/* 1124 */           boolean agg_isNull249 = false;
/* 1125 */           double agg_value285 = -1.0;
/* 1126 */           if (!false) {
/* 1127 */             agg_value285 = (double) 0;
/* 1128 */           }
/* 1129 */           if (!agg_isNull249) {
/* 1130 */             agg_isNull247 = false;
/* 1131 */             agg_value283 = agg_value285;
/* 1132 */           }
/* 1133 */         }
/* 1134 */
/* 1135 */         if (!inputadapter_isNull31) {
/* 1136 */           agg_isNull246 = false; // resultCode could change nullability.
/* 1137 */           agg_value282 = agg_value283 + inputadapter_value31;
/* 1138 */
/* 1139 */         }
/* 1140 */         boolean agg_isNull245 = agg_isNull246;
/* 1141 */         double agg_value281 = agg_value282;
/* 1142 */         if (agg_isNull245) {
/* 1143 */           boolean agg_isNull252 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 1144 */           double agg_value288 = agg_isNull252 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 1145 */           if (!agg_isNull252) {
/* 1146 */             agg_isNull245 = false;
/* 1147 */             agg_value281 = agg_value288;
/* 1148 */           }
/* 1149 */         }
/* 1150 */         boolean agg_isNull254 = true;
/* 1151 */         double agg_value290 = -1.0;
/* 1152 */
/* 1153 */         boolean agg_isNull256 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 1154 */         double agg_value292 = agg_isNull256 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(24));
/* 1155 */         boolean agg_isNull255 = agg_isNull256;
/* 1156 */         double agg_value291 = agg_value292;
/* 1157 */         if (agg_isNull255) {
/* 1158 */           boolean agg_isNull257 = false;
/* 1159 */           double agg_value293 = -1.0;
/* 1160 */           if (!false) {
/* 1161 */             agg_value293 = (double) 0;
/* 1162 */           }
/* 1163 */           if (!agg_isNull257) {
/* 1164 */             agg_isNull255 = false;
/* 1165 */             agg_value291 = agg_value293;
/* 1166 */           }
/* 1167 */         }
/* 1168 */
/* 1169 */         if (!inputadapter_isNull32) {
/* 1170 */           agg_isNull254 = false; // resultCode could change nullability.
/* 1171 */           agg_value290 = agg_value291 + inputadapter_value32;
/* 1172 */
/* 1173 */         }
/* 1174 */         boolean agg_isNull253 = agg_isNull254;
/* 1175 */         double agg_value289 = agg_value290;
/* 1176 */         if (agg_isNull253) {
/* 1177 */           boolean agg_isNull260 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 1178 */           double agg_value296 = agg_isNull260 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(24));
/* 1179 */           if (!agg_isNull260) {
/* 1180 */             agg_isNull253 = false;
/* 1181 */             agg_value289 = agg_value296;
/* 1182 */           }
/* 1183 */         }
/* 1184 */         boolean agg_isNull262 = true;
/* 1185 */         double agg_value298 = -1.0;
/* 1186 */
/* 1187 */         boolean agg_isNull264 = agg_unsafeRowAggBuffer.isNullAt(25);
/* 1188 */         double agg_value300 = agg_isNull264 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(25));
/* 1189 */         boolean agg_isNull263 = agg_isNull264;
/* 1190 */         double agg_value299 = agg_value300;
/* 1191 */         if (agg_isNull263) {
/* 1192 */           boolean agg_isNull265 = false;
/* 1193 */           double agg_value301 = -1.0;
/* 1194 */           if (!false) {
/* 1195 */             agg_value301 = (double) 0;
/* 1196 */           }
/* 1197 */           if (!agg_isNull265) {
/* 1198 */             agg_isNull263 = false;
/* 1199 */             agg_value299 = agg_value301;
/* 1200 */           }
/* 1201 */         }
/* 1202 */
/* 1203 */         if (!inputadapter_isNull33) {
/* 1204 */           agg_isNull262 = false; // resultCode could change nullability.
/* 1205 */           agg_value298 = agg_value299 + inputadapter_value33;
/* 1206 */
/* 1207 */         }
/* 1208 */         boolean agg_isNull261 = agg_isNull262;
/* 1209 */         double agg_value297 = agg_value298;
/* 1210 */         if (agg_isNull261) {
/* 1211 */           boolean agg_isNull268 = agg_unsafeRowAggBuffer.isNullAt(25);
/* 1212 */           double agg_value304 = agg_isNull268 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(25));
/* 1213 */           if (!agg_isNull268) {
/* 1214 */             agg_isNull261 = false;
/* 1215 */             agg_value297 = agg_value304;
/* 1216 */           }
/* 1217 */         }
/* 1218 */         boolean agg_isNull270 = true;
/* 1219 */         double agg_value306 = -1.0;
/* 1220 */
/* 1221 */         boolean agg_isNull272 = agg_unsafeRowAggBuffer.isNullAt(26);
/* 1222 */         double agg_value308 = agg_isNull272 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(26));
/* 1223 */         boolean agg_isNull271 = agg_isNull272;
/* 1224 */         double agg_value307 = agg_value308;
/* 1225 */         if (agg_isNull271) {
/* 1226 */           boolean agg_isNull273 = false;
/* 1227 */           double agg_value309 = -1.0;
/* 1228 */           if (!false) {
/* 1229 */             agg_value309 = (double) 0;
/* 1230 */           }
/* 1231 */           if (!agg_isNull273) {
/* 1232 */             agg_isNull271 = false;
/* 1233 */             agg_value307 = agg_value309;
/* 1234 */           }
/* 1235 */         }
/* 1236 */
/* 1237 */         if (!inputadapter_isNull34) {
/* 1238 */           agg_isNull270 = false; // resultCode could change nullability.
/* 1239 */           agg_value306 = agg_value307 + inputadapter_value34;
/* 1240 */
/* 1241 */         }
/* 1242 */         boolean agg_isNull269 = agg_isNull270;
/* 1243 */         double agg_value305 = agg_value306;
/* 1244 */         if (agg_isNull269) {
/* 1245 */           boolean agg_isNull276 = agg_unsafeRowAggBuffer.isNullAt(26);
/* 1246 */           double agg_value312 = agg_isNull276 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(26));
/* 1247 */           if (!agg_isNull276) {
/* 1248 */             agg_isNull269 = false;
/* 1249 */             agg_value305 = agg_value312;
/* 1250 */           }
/* 1251 */         }
/* 1252 */         boolean agg_isNull278 = true;
/* 1253 */         double agg_value314 = -1.0;
/* 1254 */
/* 1255 */         boolean agg_isNull280 = agg_unsafeRowAggBuffer.isNullAt(27);
/* 1256 */         double agg_value316 = agg_isNull280 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(27));
/* 1257 */         boolean agg_isNull279 = agg_isNull280;
/* 1258 */         double agg_value315 = agg_value316;
/* 1259 */         if (agg_isNull279) {
/* 1260 */           boolean agg_isNull281 = false;
/* 1261 */           double agg_value317 = -1.0;
/* 1262 */           if (!false) {
/* 1263 */             agg_value317 = (double) 0;
/* 1264 */           }
/* 1265 */           if (!agg_isNull281) {
/* 1266 */             agg_isNull279 = false;
/* 1267 */             agg_value315 = agg_value317;
/* 1268 */           }
/* 1269 */         }
/* 1270 */
/* 1271 */         if (!inputadapter_isNull35) {
/* 1272 */           agg_isNull278 = false; // resultCode could change nullability.
/* 1273 */           agg_value314 = agg_value315 + inputadapter_value35;
/* 1274 */
/* 1275 */         }
/* 1276 */         boolean agg_isNull277 = agg_isNull278;
/* 1277 */         double agg_value313 = agg_value314;
/* 1278 */         if (agg_isNull277) {
/* 1279 */           boolean agg_isNull284 = agg_unsafeRowAggBuffer.isNullAt(27);
/* 1280 */           double agg_value320 = agg_isNull284 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(27));
/* 1281 */           if (!agg_isNull284) {
/* 1282 */             agg_isNull277 = false;
/* 1283 */             agg_value313 = agg_value320;
/* 1284 */           }
/* 1285 */         }
/* 1286 */         boolean agg_isNull286 = true;
/* 1287 */         double agg_value322 = -1.0;
/* 1288 */
/* 1289 */         boolean agg_isNull288 = agg_unsafeRowAggBuffer.isNullAt(28);
/* 1290 */         double agg_value324 = agg_isNull288 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(28));
/* 1291 */         boolean agg_isNull287 = agg_isNull288;
/* 1292 */         double agg_value323 = agg_value324;
/* 1293 */         if (agg_isNull287) {
/* 1294 */           boolean agg_isNull289 = false;
/* 1295 */           double agg_value325 = -1.0;
/* 1296 */           if (!false) {
/* 1297 */             agg_value325 = (double) 0;
/* 1298 */           }
/* 1299 */           if (!agg_isNull289) {
/* 1300 */             agg_isNull287 = false;
/* 1301 */             agg_value323 = agg_value325;
/* 1302 */           }
/* 1303 */         }
/* 1304 */
/* 1305 */         if (!inputadapter_isNull36) {
/* 1306 */           agg_isNull286 = false; // resultCode could change nullability.
/* 1307 */           agg_value322 = agg_value323 + inputadapter_value36;
/* 1308 */
/* 1309 */         }
/* 1310 */         boolean agg_isNull285 = agg_isNull286;
/* 1311 */         double agg_value321 = agg_value322;
/* 1312 */         if (agg_isNull285) {
/* 1313 */           boolean agg_isNull292 = agg_unsafeRowAggBuffer.isNullAt(28);
/* 1314 */           double agg_value328 = agg_isNull292 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(28));
/* 1315 */           if (!agg_isNull292) {
/* 1316 */             agg_isNull285 = false;
/* 1317 */             agg_value321 = agg_value328;
/* 1318 */           }
/* 1319 */         }
/* 1320 */         boolean agg_isNull294 = true;
/* 1321 */         double agg_value330 = -1.0;
/* 1322 */
/* 1323 */         boolean agg_isNull296 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 1324 */         double agg_value332 = agg_isNull296 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(29));
/* 1325 */         boolean agg_isNull295 = agg_isNull296;
/* 1326 */         double agg_value331 = agg_value332;
/* 1327 */         if (agg_isNull295) {
/* 1328 */           boolean agg_isNull297 = false;
/* 1329 */           double agg_value333 = -1.0;
/* 1330 */           if (!false) {
/* 1331 */             agg_value333 = (double) 0;
/* 1332 */           }
/* 1333 */           if (!agg_isNull297) {
/* 1334 */             agg_isNull295 = false;
/* 1335 */             agg_value331 = agg_value333;
/* 1336 */           }
/* 1337 */         }
/* 1338 */
/* 1339 */         if (!inputadapter_isNull37) {
/* 1340 */           agg_isNull294 = false; // resultCode could change nullability.
/* 1341 */           agg_value330 = agg_value331 + inputadapter_value37;
/* 1342 */
/* 1343 */         }
/* 1344 */         boolean agg_isNull293 = agg_isNull294;
/* 1345 */         double agg_value329 = agg_value330;
/* 1346 */         if (agg_isNull293) {
/* 1347 */           boolean agg_isNull300 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 1348 */           double agg_value336 = agg_isNull300 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(29));
/* 1349 */           if (!agg_isNull300) {
/* 1350 */             agg_isNull293 = false;
/* 1351 */             agg_value329 = agg_value336;
/* 1352 */           }
/* 1353 */         }
/* 1354 */         boolean agg_isNull302 = true;
/* 1355 */         double agg_value338 = -1.0;
/* 1356 */
/* 1357 */         boolean agg_isNull304 = agg_unsafeRowAggBuffer.isNullAt(30);
/* 1358 */         double agg_value340 = agg_isNull304 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(30));
/* 1359 */         boolean agg_isNull303 = agg_isNull304;
/* 1360 */         double agg_value339 = agg_value340;
/* 1361 */         if (agg_isNull303) {
/* 1362 */           boolean agg_isNull305 = false;
/* 1363 */           double agg_value341 = -1.0;
/* 1364 */           if (!false) {
/* 1365 */             agg_value341 = (double) 0;
/* 1366 */           }
/* 1367 */           if (!agg_isNull305) {
/* 1368 */             agg_isNull303 = false;
/* 1369 */             agg_value339 = agg_value341;
/* 1370 */           }
/* 1371 */         }
/* 1372 */
/* 1373 */         if (!inputadapter_isNull38) {
/* 1374 */           agg_isNull302 = false; // resultCode could change nullability.
/* 1375 */           agg_value338 = agg_value339 + inputadapter_value38;
/* 1376 */
/* 1377 */         }
/* 1378 */         boolean agg_isNull301 = agg_isNull302;
/* 1379 */         double agg_value337 = agg_value338;
/* 1380 */         if (agg_isNull301) {
/* 1381 */           boolean agg_isNull308 = agg_unsafeRowAggBuffer.isNullAt(30);
/* 1382 */           double agg_value344 = agg_isNull308 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(30));
/* 1383 */           if (!agg_isNull308) {
/* 1384 */             agg_isNull301 = false;
/* 1385 */             agg_value337 = agg_value344;
/* 1386 */           }
/* 1387 */         }
/* 1388 */         boolean agg_isNull310 = true;
/* 1389 */         double agg_value346 = -1.0;
/* 1390 */
/* 1391 */         boolean agg_isNull312 = agg_unsafeRowAggBuffer.isNullAt(31);
/* 1392 */         double agg_value348 = agg_isNull312 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(31));
/* 1393 */         boolean agg_isNull311 = agg_isNull312;
/* 1394 */         double agg_value347 = agg_value348;
/* 1395 */         if (agg_isNull311) {
/* 1396 */           boolean agg_isNull313 = false;
/* 1397 */           double agg_value349 = -1.0;
/* 1398 */           if (!false) {
/* 1399 */             agg_value349 = (double) 0;
/* 1400 */           }
/* 1401 */           if (!agg_isNull313) {
/* 1402 */             agg_isNull311 = false;
/* 1403 */             agg_value347 = agg_value349;
/* 1404 */           }
/* 1405 */         }
/* 1406 */
/* 1407 */         if (!inputadapter_isNull39) {
/* 1408 */           agg_isNull310 = false; // resultCode could change nullability.
/* 1409 */           agg_value346 = agg_value347 + inputadapter_value39;
/* 1410 */
/* 1411 */         }
/* 1412 */         boolean agg_isNull309 = agg_isNull310;
/* 1413 */         double agg_value345 = agg_value346;
/* 1414 */         if (agg_isNull309) {
/* 1415 */           boolean agg_isNull316 = agg_unsafeRowAggBuffer.isNullAt(31);
/* 1416 */           double agg_value352 = agg_isNull316 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(31));
/* 1417 */           if (!agg_isNull316) {
/* 1418 */             agg_isNull309 = false;
/* 1419 */             agg_value345 = agg_value352;
/* 1420 */           }
/* 1421 */         }
/* 1422 */         boolean agg_isNull318 = true;
/* 1423 */         double agg_value354 = -1.0;
/* 1424 */
/* 1425 */         boolean agg_isNull320 = agg_unsafeRowAggBuffer.isNullAt(32);
/* 1426 */         double agg_value356 = agg_isNull320 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(32));
/* 1427 */         boolean agg_isNull319 = agg_isNull320;
/* 1428 */         double agg_value355 = agg_value356;
/* 1429 */         if (agg_isNull319) {
/* 1430 */           boolean agg_isNull321 = false;
/* 1431 */           double agg_value357 = -1.0;
/* 1432 */           if (!false) {
/* 1433 */             agg_value357 = (double) 0;
/* 1434 */           }
/* 1435 */           if (!agg_isNull321) {
/* 1436 */             agg_isNull319 = false;
/* 1437 */             agg_value355 = agg_value357;
/* 1438 */           }
/* 1439 */         }
/* 1440 */
/* 1441 */         if (!inputadapter_isNull40) {
/* 1442 */           agg_isNull318 = false; // resultCode could change nullability.
/* 1443 */           agg_value354 = agg_value355 + inputadapter_value40;
/* 1444 */
/* 1445 */         }
/* 1446 */         boolean agg_isNull317 = agg_isNull318;
/* 1447 */         double agg_value353 = agg_value354;
/* 1448 */         if (agg_isNull317) {
/* 1449 */           boolean agg_isNull324 = agg_unsafeRowAggBuffer.isNullAt(32);
/* 1450 */           double agg_value360 = agg_isNull324 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(32));
/* 1451 */           if (!agg_isNull324) {
/* 1452 */             agg_isNull317 = false;
/* 1453 */             agg_value353 = agg_value360;
/* 1454 */           }
/* 1455 */         }
/* 1456 */         boolean agg_isNull326 = true;
/* 1457 */         double agg_value362 = -1.0;
/* 1458 */
/* 1459 */         boolean agg_isNull328 = agg_unsafeRowAggBuffer.isNullAt(33);
/* 1460 */         double agg_value364 = agg_isNull328 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(33));
/* 1461 */         boolean agg_isNull327 = agg_isNull328;
/* 1462 */         double agg_value363 = agg_value364;
/* 1463 */         if (agg_isNull327) {
/* 1464 */           boolean agg_isNull329 = false;
/* 1465 */           double agg_value365 = -1.0;
/* 1466 */           if (!false) {
/* 1467 */             agg_value365 = (double) 0;
/* 1468 */           }
/* 1469 */           if (!agg_isNull329) {
/* 1470 */             agg_isNull327 = false;
/* 1471 */             agg_value363 = agg_value365;
/* 1472 */           }
/* 1473 */         }
/* 1474 */
/* 1475 */         if (!inputadapter_isNull41) {
/* 1476 */           agg_isNull326 = false; // resultCode could change nullability.
/* 1477 */           agg_value362 = agg_value363 + inputadapter_value41;
/* 1478 */
/* 1479 */         }
/* 1480 */         boolean agg_isNull325 = agg_isNull326;
/* 1481 */         double agg_value361 = agg_value362;
/* 1482 */         if (agg_isNull325) {
/* 1483 */           boolean agg_isNull332 = agg_unsafeRowAggBuffer.isNullAt(33);
/* 1484 */           double agg_value368 = agg_isNull332 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(33));
/* 1485 */           if (!agg_isNull332) {
/* 1486 */             agg_isNull325 = false;
/* 1487 */             agg_value361 = agg_value368;
/* 1488 */           }
/* 1489 */         }
/* 1490 */         boolean agg_isNull334 = true;
/* 1491 */         double agg_value370 = -1.0;
/* 1492 */
/* 1493 */         boolean agg_isNull336 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 1494 */         double agg_value372 = agg_isNull336 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(34));
/* 1495 */         boolean agg_isNull335 = agg_isNull336;
/* 1496 */         double agg_value371 = agg_value372;
/* 1497 */         if (agg_isNull335) {
/* 1498 */           boolean agg_isNull337 = false;
/* 1499 */           double agg_value373 = -1.0;
/* 1500 */           if (!false) {
/* 1501 */             agg_value373 = (double) 0;
/* 1502 */           }
/* 1503 */           if (!agg_isNull337) {
/* 1504 */             agg_isNull335 = false;
/* 1505 */             agg_value371 = agg_value373;
/* 1506 */           }
/* 1507 */         }
/* 1508 */
/* 1509 */         if (!inputadapter_isNull42) {
/* 1510 */           agg_isNull334 = false; // resultCode could change nullability.
/* 1511 */           agg_value370 = agg_value371 + inputadapter_value42;
/* 1512 */
/* 1513 */         }
/* 1514 */         boolean agg_isNull333 = agg_isNull334;
/* 1515 */         double agg_value369 = agg_value370;
/* 1516 */         if (agg_isNull333) {
/* 1517 */           boolean agg_isNull340 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 1518 */           double agg_value376 = agg_isNull340 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(34));
/* 1519 */           if (!agg_isNull340) {
/* 1520 */             agg_isNull333 = false;
/* 1521 */             agg_value369 = agg_value376;
/* 1522 */           }
/* 1523 */         }
/* 1524 */         boolean agg_isNull342 = true;
/* 1525 */         double agg_value378 = -1.0;
/* 1526 */
/* 1527 */         boolean agg_isNull344 = agg_unsafeRowAggBuffer.isNullAt(35);
/* 1528 */         double agg_value380 = agg_isNull344 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(35));
/* 1529 */         boolean agg_isNull343 = agg_isNull344;
/* 1530 */         double agg_value379 = agg_value380;
/* 1531 */         if (agg_isNull343) {
/* 1532 */           boolean agg_isNull345 = false;
/* 1533 */           double agg_value381 = -1.0;
/* 1534 */           if (!false) {
/* 1535 */             agg_value381 = (double) 0;
/* 1536 */           }
/* 1537 */           if (!agg_isNull345) {
/* 1538 */             agg_isNull343 = false;
/* 1539 */             agg_value379 = agg_value381;
/* 1540 */           }
/* 1541 */         }
/* 1542 */
/* 1543 */         if (!inputadapter_isNull43) {
/* 1544 */           agg_isNull342 = false; // resultCode could change nullability.
/* 1545 */           agg_value378 = agg_value379 + inputadapter_value43;
/* 1546 */
/* 1547 */         }
/* 1548 */         boolean agg_isNull341 = agg_isNull342;
/* 1549 */         double agg_value377 = agg_value378;
/* 1550 */         if (agg_isNull341) {
/* 1551 */           boolean agg_isNull348 = agg_unsafeRowAggBuffer.isNullAt(35);
/* 1552 */           double agg_value384 = agg_isNull348 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(35));
/* 1553 */           if (!agg_isNull348) {
/* 1554 */             agg_isNull341 = false;
/* 1555 */             agg_value377 = agg_value384;
/* 1556 */           }
/* 1557 */         }
/* 1558 */         // update unsafe row buffer
/* 1559 */         if (!agg_isNull61) {
/* 1560 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value97);
/* 1561 */         } else {
/* 1562 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 1563 */         }
/* 1564 */
/* 1565 */         if (!agg_isNull69) {
/* 1566 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value105);
/* 1567 */         } else {
/* 1568 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 1569 */         }
/* 1570 */
/* 1571 */         if (!agg_isNull77) {
/* 1572 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value113);
/* 1573 */         } else {
/* 1574 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 1575 */         }
/* 1576 */
/* 1577 */         if (!agg_isNull85) {
/* 1578 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value121);
/* 1579 */         } else {
/* 1580 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 1581 */         }
/* 1582 */
/* 1583 */         if (!agg_isNull93) {
/* 1584 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value129);
/* 1585 */         } else {
/* 1586 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 1587 */         }
/* 1588 */
/* 1589 */         if (!agg_isNull101) {
/* 1590 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value137);
/* 1591 */         } else {
/* 1592 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 1593 */         }
/* 1594 */
/* 1595 */         if (!agg_isNull109) {
/* 1596 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value145);
/* 1597 */         } else {
/* 1598 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 1599 */         }
/* 1600 */
/* 1601 */         if (!agg_isNull117) {
/* 1602 */           agg_unsafeRowAggBuffer.setDouble(7, agg_value153);
/* 1603 */         } else {
/* 1604 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 1605 */         }
/* 1606 */
/* 1607 */         if (!agg_isNull125) {
/* 1608 */           agg_unsafeRowAggBuffer.setDouble(8, agg_value161);
/* 1609 */         } else {
/* 1610 */           agg_unsafeRowAggBuffer.setNullAt(8);
/* 1611 */         }
/* 1612 */
/* 1613 */         if (!agg_isNull133) {
/* 1614 */           agg_unsafeRowAggBuffer.setDouble(9, agg_value169);
/* 1615 */         } else {
/* 1616 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 1617 */         }
/* 1618 */
/* 1619 */         if (!agg_isNull141) {
/* 1620 */           agg_unsafeRowAggBuffer.setDouble(10, agg_value177);
/* 1621 */         } else {
/* 1622 */           agg_unsafeRowAggBuffer.setNullAt(10);
/* 1623 */         }
/* 1624 */
/* 1625 */         if (!agg_isNull149) {
/* 1626 */           agg_unsafeRowAggBuffer.setDouble(11, agg_value185);
/* 1627 */         } else {
/* 1628 */           agg_unsafeRowAggBuffer.setNullAt(11);
/* 1629 */         }
/* 1630 */
/* 1631 */         if (!agg_isNull157) {
/* 1632 */           agg_unsafeRowAggBuffer.setDouble(12, agg_value193);
/* 1633 */         } else {
/* 1634 */           agg_unsafeRowAggBuffer.setNullAt(12);
/* 1635 */         }
/* 1636 */
/* 1637 */         if (!agg_isNull165) {
/* 1638 */           agg_unsafeRowAggBuffer.setDouble(13, agg_value201);
/* 1639 */         } else {
/* 1640 */           agg_unsafeRowAggBuffer.setNullAt(13);
/* 1641 */         }
/* 1642 */
/* 1643 */         if (!agg_isNull173) {
/* 1644 */           agg_unsafeRowAggBuffer.setDouble(14, agg_value209);
/* 1645 */         } else {
/* 1646 */           agg_unsafeRowAggBuffer.setNullAt(14);
/* 1647 */         }
/* 1648 */
/* 1649 */         if (!agg_isNull181) {
/* 1650 */           agg_unsafeRowAggBuffer.setDouble(15, agg_value217);
/* 1651 */         } else {
/* 1652 */           agg_unsafeRowAggBuffer.setNullAt(15);
/* 1653 */         }
/* 1654 */
/* 1655 */         if (!agg_isNull189) {
/* 1656 */           agg_unsafeRowAggBuffer.setDouble(16, agg_value225);
/* 1657 */         } else {
/* 1658 */           agg_unsafeRowAggBuffer.setNullAt(16);
/* 1659 */         }
/* 1660 */
/* 1661 */         if (!agg_isNull197) {
/* 1662 */           agg_unsafeRowAggBuffer.setDouble(17, agg_value233);
/* 1663 */         } else {
/* 1664 */           agg_unsafeRowAggBuffer.setNullAt(17);
/* 1665 */         }
/* 1666 */
/* 1667 */         if (!agg_isNull205) {
/* 1668 */           agg_unsafeRowAggBuffer.setDouble(18, agg_value241);
/* 1669 */         } else {
/* 1670 */           agg_unsafeRowAggBuffer.setNullAt(18);
/* 1671 */         }
/* 1672 */
/* 1673 */         if (!agg_isNull213) {
/* 1674 */           agg_unsafeRowAggBuffer.setDouble(19, agg_value249);
/* 1675 */         } else {
/* 1676 */           agg_unsafeRowAggBuffer.setNullAt(19);
/* 1677 */         }
/* 1678 */
/* 1679 */         if (!agg_isNull221) {
/* 1680 */           agg_unsafeRowAggBuffer.setDouble(20, agg_value257);
/* 1681 */         } else {
/* 1682 */           agg_unsafeRowAggBuffer.setNullAt(20);
/* 1683 */         }
/* 1684 */
/* 1685 */         if (!agg_isNull229) {
/* 1686 */           agg_unsafeRowAggBuffer.setDouble(21, agg_value265);
/* 1687 */         } else {
/* 1688 */           agg_unsafeRowAggBuffer.setNullAt(21);
/* 1689 */         }
/* 1690 */
/* 1691 */         if (!agg_isNull237) {
/* 1692 */           agg_unsafeRowAggBuffer.setDouble(22, agg_value273);
/* 1693 */         } else {
/* 1694 */           agg_unsafeRowAggBuffer.setNullAt(22);
/* 1695 */         }
/* 1696 */
/* 1697 */         if (!agg_isNull245) {
/* 1698 */           agg_unsafeRowAggBuffer.setDouble(23, agg_value281);
/* 1699 */         } else {
/* 1700 */           agg_unsafeRowAggBuffer.setNullAt(23);
/* 1701 */         }
/* 1702 */
/* 1703 */         if (!agg_isNull253) {
/* 1704 */           agg_unsafeRowAggBuffer.setDouble(24, agg_value289);
/* 1705 */         } else {
/* 1706 */           agg_unsafeRowAggBuffer.setNullAt(24);
/* 1707 */         }
/* 1708 */
/* 1709 */         if (!agg_isNull261) {
/* 1710 */           agg_unsafeRowAggBuffer.setDouble(25, agg_value297);
/* 1711 */         } else {
/* 1712 */           agg_unsafeRowAggBuffer.setNullAt(25);
/* 1713 */         }
/* 1714 */
/* 1715 */         if (!agg_isNull269) {
/* 1716 */           agg_unsafeRowAggBuffer.setDouble(26, agg_value305);
/* 1717 */         } else {
/* 1718 */           agg_unsafeRowAggBuffer.setNullAt(26);
/* 1719 */         }
/* 1720 */
/* 1721 */         if (!agg_isNull277) {
/* 1722 */           agg_unsafeRowAggBuffer.setDouble(27, agg_value313);
/* 1723 */         } else {
/* 1724 */           agg_unsafeRowAggBuffer.setNullAt(27);
/* 1725 */         }
/* 1726 */
/* 1727 */         if (!agg_isNull285) {
/* 1728 */           agg_unsafeRowAggBuffer.setDouble(28, agg_value321);
/* 1729 */         } else {
/* 1730 */           agg_unsafeRowAggBuffer.setNullAt(28);
/* 1731 */         }
/* 1732 */
/* 1733 */         if (!agg_isNull293) {
/* 1734 */           agg_unsafeRowAggBuffer.setDouble(29, agg_value329);
/* 1735 */         } else {
/* 1736 */           agg_unsafeRowAggBuffer.setNullAt(29);
/* 1737 */         }
/* 1738 */
/* 1739 */         if (!agg_isNull301) {
/* 1740 */           agg_unsafeRowAggBuffer.setDouble(30, agg_value337);
/* 1741 */         } else {
/* 1742 */           agg_unsafeRowAggBuffer.setNullAt(30);
/* 1743 */         }
/* 1744 */
/* 1745 */         if (!agg_isNull309) {
/* 1746 */           agg_unsafeRowAggBuffer.setDouble(31, agg_value345);
/* 1747 */         } else {
/* 1748 */           agg_unsafeRowAggBuffer.setNullAt(31);
/* 1749 */         }
/* 1750 */
/* 1751 */         if (!agg_isNull317) {
/* 1752 */           agg_unsafeRowAggBuffer.setDouble(32, agg_value353);
/* 1753 */         } else {
/* 1754 */           agg_unsafeRowAggBuffer.setNullAt(32);
/* 1755 */         }
/* 1756 */
/* 1757 */         if (!agg_isNull325) {
/* 1758 */           agg_unsafeRowAggBuffer.setDouble(33, agg_value361);
/* 1759 */         } else {
/* 1760 */           agg_unsafeRowAggBuffer.setNullAt(33);
/* 1761 */         }
/* 1762 */
/* 1763 */         if (!agg_isNull333) {
/* 1764 */           agg_unsafeRowAggBuffer.setDouble(34, agg_value369);
/* 1765 */         } else {
/* 1766 */           agg_unsafeRowAggBuffer.setNullAt(34);
/* 1767 */         }
/* 1768 */
/* 1769 */         if (!agg_isNull341) {
/* 1770 */           agg_unsafeRowAggBuffer.setDouble(35, agg_value377);
/* 1771 */         } else {
/* 1772 */           agg_unsafeRowAggBuffer.setNullAt(35);
/* 1773 */         }
/* 1774 */
/* 1775 */       }
/* 1776 */       if (shouldStop()) return;
/* 1777 */     }
/* 1778 */
/* 1779 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1780 */   }
/* 1781 */
/* 1782 */   protected void processNext() throws java.io.IOException {
/* 1783 */     if (!agg_initAgg) {
/* 1784 */       agg_initAgg = true;
/* 1785 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1786 */       agg_doAggregateWithKeys();
/* 1787 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1788 */     }
/* 1789 */
/* 1790 */     // output the result
/* 1791 */
/* 1792 */     while (agg_mapIter.next()) {
/* 1793 */       wholestagecodegen_numOutputRows.add(1);
/* 1794 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1795 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1796 */
/* 1797 */       boolean agg_isNull349 = agg_aggKey.isNullAt(0);
/* 1798 */       UTF8String agg_value385 = agg_isNull349 ? null : (agg_aggKey.getUTF8String(0));
/* 1799 */       boolean agg_isNull350 = agg_aggKey.isNullAt(1);
/* 1800 */       int agg_value386 = agg_isNull350 ? -1 : (agg_aggKey.getInt(1));
/* 1801 */       boolean agg_isNull351 = agg_aggKey.isNullAt(2);
/* 1802 */       UTF8String agg_value387 = agg_isNull351 ? null : (agg_aggKey.getUTF8String(2));
/* 1803 */       boolean agg_isNull352 = agg_aggKey.isNullAt(3);
/* 1804 */       UTF8String agg_value388 = agg_isNull352 ? null : (agg_aggKey.getUTF8String(3));
/* 1805 */       boolean agg_isNull353 = agg_aggKey.isNullAt(4);
/* 1806 */       UTF8String agg_value389 = agg_isNull353 ? null : (agg_aggKey.getUTF8String(4));
/* 1807 */       boolean agg_isNull354 = agg_aggKey.isNullAt(5);
/* 1808 */       UTF8String agg_value390 = agg_isNull354 ? null : (agg_aggKey.getUTF8String(5));
/* 1809 */       UTF8String agg_value391 = agg_aggKey.getUTF8String(6);
/* 1810 */       boolean agg_isNull356 = agg_aggKey.isNullAt(7);
/* 1811 */       int agg_value392 = agg_isNull356 ? -1 : (agg_aggKey.getInt(7));
/* 1812 */       boolean agg_isNull357 = agg_aggBuffer.isNullAt(0);
/* 1813 */       double agg_value393 = agg_isNull357 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 1814 */       boolean agg_isNull358 = agg_aggBuffer.isNullAt(1);
/* 1815 */       double agg_value394 = agg_isNull358 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 1816 */       boolean agg_isNull359 = agg_aggBuffer.isNullAt(2);
/* 1817 */       double agg_value395 = agg_isNull359 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 1818 */       boolean agg_isNull360 = agg_aggBuffer.isNullAt(3);
/* 1819 */       double agg_value396 = agg_isNull360 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 1820 */       boolean agg_isNull361 = agg_aggBuffer.isNullAt(4);
/* 1821 */       double agg_value397 = agg_isNull361 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 1822 */       boolean agg_isNull362 = agg_aggBuffer.isNullAt(5);
/* 1823 */       double agg_value398 = agg_isNull362 ? -1.0 : (agg_aggBuffer.getDouble(5));
/* 1824 */       boolean agg_isNull363 = agg_aggBuffer.isNullAt(6);
/* 1825 */       double agg_value399 = agg_isNull363 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 1826 */       boolean agg_isNull364 = agg_aggBuffer.isNullAt(7);
/* 1827 */       double agg_value400 = agg_isNull364 ? -1.0 : (agg_aggBuffer.getDouble(7));
/* 1828 */       boolean agg_isNull365 = agg_aggBuffer.isNullAt(8);
/* 1829 */       double agg_value401 = agg_isNull365 ? -1.0 : (agg_aggBuffer.getDouble(8));
/* 1830 */       boolean agg_isNull366 = agg_aggBuffer.isNullAt(9);
/* 1831 */       double agg_value402 = agg_isNull366 ? -1.0 : (agg_aggBuffer.getDouble(9));
/* 1832 */       boolean agg_isNull367 = agg_aggBuffer.isNullAt(10);
/* 1833 */       double agg_value403 = agg_isNull367 ? -1.0 : (agg_aggBuffer.getDouble(10));
/* 1834 */       boolean agg_isNull368 = agg_aggBuffer.isNullAt(11);
/* 1835 */       double agg_value404 = agg_isNull368 ? -1.0 : (agg_aggBuffer.getDouble(11));
/* 1836 */       boolean agg_isNull369 = agg_aggBuffer.isNullAt(12);
/* 1837 */       double agg_value405 = agg_isNull369 ? -1.0 : (agg_aggBuffer.getDouble(12));
/* 1838 */       boolean agg_isNull370 = agg_aggBuffer.isNullAt(13);
/* 1839 */       double agg_value406 = agg_isNull370 ? -1.0 : (agg_aggBuffer.getDouble(13));
/* 1840 */       boolean agg_isNull371 = agg_aggBuffer.isNullAt(14);
/* 1841 */       double agg_value407 = agg_isNull371 ? -1.0 : (agg_aggBuffer.getDouble(14));
/* 1842 */       boolean agg_isNull372 = agg_aggBuffer.isNullAt(15);
/* 1843 */       double agg_value408 = agg_isNull372 ? -1.0 : (agg_aggBuffer.getDouble(15));
/* 1844 */       boolean agg_isNull373 = agg_aggBuffer.isNullAt(16);
/* 1845 */       double agg_value409 = agg_isNull373 ? -1.0 : (agg_aggBuffer.getDouble(16));
/* 1846 */       boolean agg_isNull374 = agg_aggBuffer.isNullAt(17);
/* 1847 */       double agg_value410 = agg_isNull374 ? -1.0 : (agg_aggBuffer.getDouble(17));
/* 1848 */       boolean agg_isNull375 = agg_aggBuffer.isNullAt(18);
/* 1849 */       double agg_value411 = agg_isNull375 ? -1.0 : (agg_aggBuffer.getDouble(18));
/* 1850 */       boolean agg_isNull376 = agg_aggBuffer.isNullAt(19);
/* 1851 */       double agg_value412 = agg_isNull376 ? -1.0 : (agg_aggBuffer.getDouble(19));
/* 1852 */       boolean agg_isNull377 = agg_aggBuffer.isNullAt(20);
/* 1853 */       double agg_value413 = agg_isNull377 ? -1.0 : (agg_aggBuffer.getDouble(20));
/* 1854 */       boolean agg_isNull378 = agg_aggBuffer.isNullAt(21);
/* 1855 */       double agg_value414 = agg_isNull378 ? -1.0 : (agg_aggBuffer.getDouble(21));
/* 1856 */       boolean agg_isNull379 = agg_aggBuffer.isNullAt(22);
/* 1857 */       double agg_value415 = agg_isNull379 ? -1.0 : (agg_aggBuffer.getDouble(22));
/* 1858 */       boolean agg_isNull380 = agg_aggBuffer.isNullAt(23);
/* 1859 */       double agg_value416 = agg_isNull380 ? -1.0 : (agg_aggBuffer.getDouble(23));
/* 1860 */       boolean agg_isNull381 = agg_aggBuffer.isNullAt(24);
/* 1861 */       double agg_value417 = agg_isNull381 ? -1.0 : (agg_aggBuffer.getDouble(24));
/* 1862 */       boolean agg_isNull382 = agg_aggBuffer.isNullAt(25);
/* 1863 */       double agg_value418 = agg_isNull382 ? -1.0 : (agg_aggBuffer.getDouble(25));
/* 1864 */       boolean agg_isNull383 = agg_aggBuffer.isNullAt(26);
/* 1865 */       double agg_value419 = agg_isNull383 ? -1.0 : (agg_aggBuffer.getDouble(26));
/* 1866 */       boolean agg_isNull384 = agg_aggBuffer.isNullAt(27);
/* 1867 */       double agg_value420 = agg_isNull384 ? -1.0 : (agg_aggBuffer.getDouble(27));
/* 1868 */       boolean agg_isNull385 = agg_aggBuffer.isNullAt(28);
/* 1869 */       double agg_value421 = agg_isNull385 ? -1.0 : (agg_aggBuffer.getDouble(28));
/* 1870 */       boolean agg_isNull386 = agg_aggBuffer.isNullAt(29);
/* 1871 */       double agg_value422 = agg_isNull386 ? -1.0 : (agg_aggBuffer.getDouble(29));
/* 1872 */       boolean agg_isNull387 = agg_aggBuffer.isNullAt(30);
/* 1873 */       double agg_value423 = agg_isNull387 ? -1.0 : (agg_aggBuffer.getDouble(30));
/* 1874 */       boolean agg_isNull388 = agg_aggBuffer.isNullAt(31);
/* 1875 */       double agg_value424 = agg_isNull388 ? -1.0 : (agg_aggBuffer.getDouble(31));
/* 1876 */       boolean agg_isNull389 = agg_aggBuffer.isNullAt(32);
/* 1877 */       double agg_value425 = agg_isNull389 ? -1.0 : (agg_aggBuffer.getDouble(32));
/* 1878 */       boolean agg_isNull390 = agg_aggBuffer.isNullAt(33);
/* 1879 */       double agg_value426 = agg_isNull390 ? -1.0 : (agg_aggBuffer.getDouble(33));
/* 1880 */       boolean agg_isNull391 = agg_aggBuffer.isNullAt(34);
/* 1881 */       double agg_value427 = agg_isNull391 ? -1.0 : (agg_aggBuffer.getDouble(34));
/* 1882 */       boolean agg_isNull392 = agg_aggBuffer.isNullAt(35);
/* 1883 */       double agg_value428 = agg_isNull392 ? -1.0 : (agg_aggBuffer.getDouble(35));
/* 1884 */
/* 1885 */       agg_holder1.reset();
/* 1886 */
/* 1887 */       agg_rowWriter1.zeroOutNullBytes();
/* 1888 */
/* 1889 */       if (agg_isNull349) {
/* 1890 */         agg_rowWriter1.setNullAt(0);
/* 1891 */       } else {
/* 1892 */         agg_rowWriter1.write(0, agg_value385);
/* 1893 */       }
/* 1894 */
/* 1895 */       if (agg_isNull350) {
/* 1896 */         agg_rowWriter1.setNullAt(1);
/* 1897 */       } else {
/* 1898 */         agg_rowWriter1.write(1, agg_value386);
/* 1899 */       }
/* 1900 */
/* 1901 */       if (agg_isNull351) {
/* 1902 */         agg_rowWriter1.setNullAt(2);
/* 1903 */       } else {
/* 1904 */         agg_rowWriter1.write(2, agg_value387);
/* 1905 */       }
/* 1906 */
/* 1907 */       if (agg_isNull352) {
/* 1908 */         agg_rowWriter1.setNullAt(3);
/* 1909 */       } else {
/* 1910 */         agg_rowWriter1.write(3, agg_value388);
/* 1911 */       }
/* 1912 */
/* 1913 */       if (agg_isNull353) {
/* 1914 */         agg_rowWriter1.setNullAt(4);
/* 1915 */       } else {
/* 1916 */         agg_rowWriter1.write(4, agg_value389);
/* 1917 */       }
/* 1918 */
/* 1919 */       if (agg_isNull354) {
/* 1920 */         agg_rowWriter1.setNullAt(5);
/* 1921 */       } else {
/* 1922 */         agg_rowWriter1.write(5, agg_value390);
/* 1923 */       }
/* 1924 */
/* 1925 */       agg_rowWriter1.write(6, agg_value391);
/* 1926 */
/* 1927 */       if (agg_isNull356) {
/* 1928 */         agg_rowWriter1.setNullAt(7);
/* 1929 */       } else {
/* 1930 */         agg_rowWriter1.write(7, agg_value392);
/* 1931 */       }
/* 1932 */
/* 1933 */       if (agg_isNull357) {
/* 1934 */         agg_rowWriter1.setNullAt(8);
/* 1935 */       } else {
/* 1936 */         agg_rowWriter1.write(8, agg_value393);
/* 1937 */       }
/* 1938 */
/* 1939 */       if (agg_isNull358) {
/* 1940 */         agg_rowWriter1.setNullAt(9);
/* 1941 */       } else {
/* 1942 */         agg_rowWriter1.write(9, agg_value394);
/* 1943 */       }
/* 1944 */
/* 1945 */       if (agg_isNull359) {
/* 1946 */         agg_rowWriter1.setNullAt(10);
/* 1947 */       } else {
/* 1948 */         agg_rowWriter1.write(10, agg_value395);
/* 1949 */       }
/* 1950 */
/* 1951 */       if (agg_isNull360) {
/* 1952 */         agg_rowWriter1.setNullAt(11);
/* 1953 */       } else {
/* 1954 */         agg_rowWriter1.write(11, agg_value396);
/* 1955 */       }
/* 1956 */
/* 1957 */       if (agg_isNull361) {
/* 1958 */         agg_rowWriter1.setNullAt(12);
/* 1959 */       } else {
/* 1960 */         agg_rowWriter1.write(12, agg_value397);
/* 1961 */       }
/* 1962 */
/* 1963 */       if (agg_isNull362) {
/* 1964 */         agg_rowWriter1.setNullAt(13);
/* 1965 */       } else {
/* 1966 */         agg_rowWriter1.write(13, agg_value398);
/* 1967 */       }
/* 1968 */
/* 1969 */       if (agg_isNull363) {
/* 1970 */         agg_rowWriter1.setNullAt(14);
/* 1971 */       } else {
/* 1972 */         agg_rowWriter1.write(14, agg_value399);
/* 1973 */       }
/* 1974 */
/* 1975 */       if (agg_isNull364) {
/* 1976 */         agg_rowWriter1.setNullAt(15);
/* 1977 */       } else {
/* 1978 */         agg_rowWriter1.write(15, agg_value400);
/* 1979 */       }
/* 1980 */
/* 1981 */       if (agg_isNull365) {
/* 1982 */         agg_rowWriter1.setNullAt(16);
/* 1983 */       } else {
/* 1984 */         agg_rowWriter1.write(16, agg_value401);
/* 1985 */       }
/* 1986 */
/* 1987 */       if (agg_isNull366) {
/* 1988 */         agg_rowWriter1.setNullAt(17);
/* 1989 */       } else {
/* 1990 */         agg_rowWriter1.write(17, agg_value402);
/* 1991 */       }
/* 1992 */
/* 1993 */       if (agg_isNull367) {
/* 1994 */         agg_rowWriter1.setNullAt(18);
/* 1995 */       } else {
/* 1996 */         agg_rowWriter1.write(18, agg_value403);
/* 1997 */       }
/* 1998 */
/* 1999 */       if (agg_isNull368) {
/* 2000 */         agg_rowWriter1.setNullAt(19);
/* 2001 */       } else {
/* 2002 */         agg_rowWriter1.write(19, agg_value404);
/* 2003 */       }
/* 2004 */
/* 2005 */       if (agg_isNull369) {
/* 2006 */         agg_rowWriter1.setNullAt(20);
/* 2007 */       } else {
/* 2008 */         agg_rowWriter1.write(20, agg_value405);
/* 2009 */       }
/* 2010 */
/* 2011 */       if (agg_isNull370) {
/* 2012 */         agg_rowWriter1.setNullAt(21);
/* 2013 */       } else {
/* 2014 */         agg_rowWriter1.write(21, agg_value406);
/* 2015 */       }
/* 2016 */
/* 2017 */       if (agg_isNull371) {
/* 2018 */         agg_rowWriter1.setNullAt(22);
/* 2019 */       } else {
/* 2020 */         agg_rowWriter1.write(22, agg_value407);
/* 2021 */       }
/* 2022 */
/* 2023 */       if (agg_isNull372) {
/* 2024 */         agg_rowWriter1.setNullAt(23);
/* 2025 */       } else {
/* 2026 */         agg_rowWriter1.write(23, agg_value408);
/* 2027 */       }
/* 2028 */
/* 2029 */       if (agg_isNull373) {
/* 2030 */         agg_rowWriter1.setNullAt(24);
/* 2031 */       } else {
/* 2032 */         agg_rowWriter1.write(24, agg_value409);
/* 2033 */       }
/* 2034 */
/* 2035 */       if (agg_isNull374) {
/* 2036 */         agg_rowWriter1.setNullAt(25);
/* 2037 */       } else {
/* 2038 */         agg_rowWriter1.write(25, agg_value410);
/* 2039 */       }
/* 2040 */
/* 2041 */       if (agg_isNull375) {
/* 2042 */         agg_rowWriter1.setNullAt(26);
/* 2043 */       } else {
/* 2044 */         agg_rowWriter1.write(26, agg_value411);
/* 2045 */       }
/* 2046 */
/* 2047 */       if (agg_isNull376) {
/* 2048 */         agg_rowWriter1.setNullAt(27);
/* 2049 */       } else {
/* 2050 */         agg_rowWriter1.write(27, agg_value412);
/* 2051 */       }
/* 2052 */
/* 2053 */       if (agg_isNull377) {
/* 2054 */         agg_rowWriter1.setNullAt(28);
/* 2055 */       } else {
/* 2056 */         agg_rowWriter1.write(28, agg_value413);
/* 2057 */       }
/* 2058 */
/* 2059 */       if (agg_isNull378) {
/* 2060 */         agg_rowWriter1.setNullAt(29);
/* 2061 */       } else {
/* 2062 */         agg_rowWriter1.write(29, agg_value414);
/* 2063 */       }
/* 2064 */
/* 2065 */       if (agg_isNull379) {
/* 2066 */         agg_rowWriter1.setNullAt(30);
/* 2067 */       } else {
/* 2068 */         agg_rowWriter1.write(30, agg_value415);
/* 2069 */       }
/* 2070 */
/* 2071 */       if (agg_isNull380) {
/* 2072 */         agg_rowWriter1.setNullAt(31);
/* 2073 */       } else {
/* 2074 */         agg_rowWriter1.write(31, agg_value416);
/* 2075 */       }
/* 2076 */
/* 2077 */       if (agg_isNull381) {
/* 2078 */         agg_rowWriter1.setNullAt(32);
/* 2079 */       } else {
/* 2080 */         agg_rowWriter1.write(32, agg_value417);
/* 2081 */       }
/* 2082 */
/* 2083 */       if (agg_isNull382) {
/* 2084 */         agg_rowWriter1.setNullAt(33);
/* 2085 */       } else {
/* 2086 */         agg_rowWriter1.write(33, agg_value418);
/* 2087 */       }
/* 2088 */
/* 2089 */       if (agg_isNull383) {
/* 2090 */         agg_rowWriter1.setNullAt(34);
/* 2091 */       } else {
/* 2092 */         agg_rowWriter1.write(34, agg_value419);
/* 2093 */       }
/* 2094 */
/* 2095 */       if (agg_isNull384) {
/* 2096 */         agg_rowWriter1.setNullAt(35);
/* 2097 */       } else {
/* 2098 */         agg_rowWriter1.write(35, agg_value420);
/* 2099 */       }
/* 2100 */
/* 2101 */       if (agg_isNull385) {
/* 2102 */         agg_rowWriter1.setNullAt(36);
/* 2103 */       } else {
/* 2104 */         agg_rowWriter1.write(36, agg_value421);
/* 2105 */       }
/* 2106 */
/* 2107 */       if (agg_isNull386) {
/* 2108 */         agg_rowWriter1.setNullAt(37);
/* 2109 */       } else {
/* 2110 */         agg_rowWriter1.write(37, agg_value422);
/* 2111 */       }
/* 2112 */
/* 2113 */       if (agg_isNull387) {
/* 2114 */         agg_rowWriter1.setNullAt(38);
/* 2115 */       } else {
/* 2116 */         agg_rowWriter1.write(38, agg_value423);
/* 2117 */       }
/* 2118 */
/* 2119 */       if (agg_isNull388) {
/* 2120 */         agg_rowWriter1.setNullAt(39);
/* 2121 */       } else {
/* 2122 */         agg_rowWriter1.write(39, agg_value424);
/* 2123 */       }
/* 2124 */
/* 2125 */       if (agg_isNull389) {
/* 2126 */         agg_rowWriter1.setNullAt(40);
/* 2127 */       } else {
/* 2128 */         agg_rowWriter1.write(40, agg_value425);
/* 2129 */       }
/* 2130 */
/* 2131 */       if (agg_isNull390) {
/* 2132 */         agg_rowWriter1.setNullAt(41);
/* 2133 */       } else {
/* 2134 */         agg_rowWriter1.write(41, agg_value426);
/* 2135 */       }
/* 2136 */
/* 2137 */       if (agg_isNull391) {
/* 2138 */         agg_rowWriter1.setNullAt(42);
/* 2139 */       } else {
/* 2140 */         agg_rowWriter1.write(42, agg_value427);
/* 2141 */       }
/* 2142 */
/* 2143 */       if (agg_isNull392) {
/* 2144 */         agg_rowWriter1.setNullAt(43);
/* 2145 */       } else {
/* 2146 */         agg_rowWriter1.write(43, agg_value428);
/* 2147 */       }
/* 2148 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 2149 */       append(agg_result1);
/* 2150 */
/* 2151 */       if (shouldStop()) return;
/* 2152 */     }
/* 2153 */
/* 2154 */     agg_mapIter.close();
/* 2155 */     if (agg_sorter == null) {
/* 2156 */       agg_hashMap.free();
/* 2157 */     }
/* 2158 */   }
/* 2159 */ }
