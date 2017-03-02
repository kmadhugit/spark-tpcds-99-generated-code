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
/* 127 */     while (inputadapter_input.hasNext()) {
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
/* 332 */         boolean agg_isNull61 = false;
/* 333 */         double agg_value97 = -1.0;
/* 334 */         if (!false) {
/* 335 */           agg_value97 = (double) 0;
/* 336 */         }
/* 337 */         // evaluate aggregate function
/* 338 */         boolean agg_isNull64 = true;
/* 339 */         double agg_value100 = -1.0;
/* 340 */
/* 341 */         boolean agg_isNull66 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 342 */         double agg_value102 = agg_isNull66 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 343 */         boolean agg_isNull65 = agg_isNull66;
/* 344 */         double agg_value101 = agg_value102;
/* 345 */         if (agg_isNull65) {
/* 346 */           if (!agg_isNull61) {
/* 347 */             agg_isNull65 = false;
/* 348 */             agg_value101 = agg_value97;
/* 349 */           }
/* 350 */         }
/* 351 */
/* 352 */         if (!inputadapter_isNull8) {
/* 353 */           agg_isNull64 = false; // resultCode could change nullability.
/* 354 */           agg_value100 = agg_value101 + inputadapter_value8;
/* 355 */
/* 356 */         }
/* 357 */         boolean agg_isNull63 = agg_isNull64;
/* 358 */         double agg_value99 = agg_value100;
/* 359 */         if (agg_isNull63) {
/* 360 */           boolean agg_isNull68 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 361 */           double agg_value104 = agg_isNull68 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 362 */           if (!agg_isNull68) {
/* 363 */             agg_isNull63 = false;
/* 364 */             agg_value99 = agg_value104;
/* 365 */           }
/* 366 */         }
/* 367 */         boolean agg_isNull70 = true;
/* 368 */         double agg_value106 = -1.0;
/* 369 */
/* 370 */         boolean agg_isNull72 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 371 */         double agg_value108 = agg_isNull72 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 372 */         boolean agg_isNull71 = agg_isNull72;
/* 373 */         double agg_value107 = agg_value108;
/* 374 */         if (agg_isNull71) {
/* 375 */           if (!agg_isNull61) {
/* 376 */             agg_isNull71 = false;
/* 377 */             agg_value107 = agg_value97;
/* 378 */           }
/* 379 */         }
/* 380 */
/* 381 */         if (!inputadapter_isNull9) {
/* 382 */           agg_isNull70 = false; // resultCode could change nullability.
/* 383 */           agg_value106 = agg_value107 + inputadapter_value9;
/* 384 */
/* 385 */         }
/* 386 */         boolean agg_isNull69 = agg_isNull70;
/* 387 */         double agg_value105 = agg_value106;
/* 388 */         if (agg_isNull69) {
/* 389 */           boolean agg_isNull74 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 390 */           double agg_value110 = agg_isNull74 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 391 */           if (!agg_isNull74) {
/* 392 */             agg_isNull69 = false;
/* 393 */             agg_value105 = agg_value110;
/* 394 */           }
/* 395 */         }
/* 396 */         boolean agg_isNull76 = true;
/* 397 */         double agg_value112 = -1.0;
/* 398 */
/* 399 */         boolean agg_isNull78 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 400 */         double agg_value114 = agg_isNull78 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 401 */         boolean agg_isNull77 = agg_isNull78;
/* 402 */         double agg_value113 = agg_value114;
/* 403 */         if (agg_isNull77) {
/* 404 */           if (!agg_isNull61) {
/* 405 */             agg_isNull77 = false;
/* 406 */             agg_value113 = agg_value97;
/* 407 */           }
/* 408 */         }
/* 409 */
/* 410 */         if (!inputadapter_isNull10) {
/* 411 */           agg_isNull76 = false; // resultCode could change nullability.
/* 412 */           agg_value112 = agg_value113 + inputadapter_value10;
/* 413 */
/* 414 */         }
/* 415 */         boolean agg_isNull75 = agg_isNull76;
/* 416 */         double agg_value111 = agg_value112;
/* 417 */         if (agg_isNull75) {
/* 418 */           boolean agg_isNull80 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 419 */           double agg_value116 = agg_isNull80 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 420 */           if (!agg_isNull80) {
/* 421 */             agg_isNull75 = false;
/* 422 */             agg_value111 = agg_value116;
/* 423 */           }
/* 424 */         }
/* 425 */         boolean agg_isNull82 = true;
/* 426 */         double agg_value118 = -1.0;
/* 427 */
/* 428 */         boolean agg_isNull84 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 429 */         double agg_value120 = agg_isNull84 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 430 */         boolean agg_isNull83 = agg_isNull84;
/* 431 */         double agg_value119 = agg_value120;
/* 432 */         if (agg_isNull83) {
/* 433 */           if (!agg_isNull61) {
/* 434 */             agg_isNull83 = false;
/* 435 */             agg_value119 = agg_value97;
/* 436 */           }
/* 437 */         }
/* 438 */
/* 439 */         if (!inputadapter_isNull11) {
/* 440 */           agg_isNull82 = false; // resultCode could change nullability.
/* 441 */           agg_value118 = agg_value119 + inputadapter_value11;
/* 442 */
/* 443 */         }
/* 444 */         boolean agg_isNull81 = agg_isNull82;
/* 445 */         double agg_value117 = agg_value118;
/* 446 */         if (agg_isNull81) {
/* 447 */           boolean agg_isNull86 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 448 */           double agg_value122 = agg_isNull86 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 449 */           if (!agg_isNull86) {
/* 450 */             agg_isNull81 = false;
/* 451 */             agg_value117 = agg_value122;
/* 452 */           }
/* 453 */         }
/* 454 */         boolean agg_isNull88 = true;
/* 455 */         double agg_value124 = -1.0;
/* 456 */
/* 457 */         boolean agg_isNull90 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 458 */         double agg_value126 = agg_isNull90 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 459 */         boolean agg_isNull89 = agg_isNull90;
/* 460 */         double agg_value125 = agg_value126;
/* 461 */         if (agg_isNull89) {
/* 462 */           if (!agg_isNull61) {
/* 463 */             agg_isNull89 = false;
/* 464 */             agg_value125 = agg_value97;
/* 465 */           }
/* 466 */         }
/* 467 */
/* 468 */         if (!inputadapter_isNull12) {
/* 469 */           agg_isNull88 = false; // resultCode could change nullability.
/* 470 */           agg_value124 = agg_value125 + inputadapter_value12;
/* 471 */
/* 472 */         }
/* 473 */         boolean agg_isNull87 = agg_isNull88;
/* 474 */         double agg_value123 = agg_value124;
/* 475 */         if (agg_isNull87) {
/* 476 */           boolean agg_isNull92 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 477 */           double agg_value128 = agg_isNull92 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 478 */           if (!agg_isNull92) {
/* 479 */             agg_isNull87 = false;
/* 480 */             agg_value123 = agg_value128;
/* 481 */           }
/* 482 */         }
/* 483 */         boolean agg_isNull94 = true;
/* 484 */         double agg_value130 = -1.0;
/* 485 */
/* 486 */         boolean agg_isNull96 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 487 */         double agg_value132 = agg_isNull96 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 488 */         boolean agg_isNull95 = agg_isNull96;
/* 489 */         double agg_value131 = agg_value132;
/* 490 */         if (agg_isNull95) {
/* 491 */           if (!agg_isNull61) {
/* 492 */             agg_isNull95 = false;
/* 493 */             agg_value131 = agg_value97;
/* 494 */           }
/* 495 */         }
/* 496 */
/* 497 */         if (!inputadapter_isNull13) {
/* 498 */           agg_isNull94 = false; // resultCode could change nullability.
/* 499 */           agg_value130 = agg_value131 + inputadapter_value13;
/* 500 */
/* 501 */         }
/* 502 */         boolean agg_isNull93 = agg_isNull94;
/* 503 */         double agg_value129 = agg_value130;
/* 504 */         if (agg_isNull93) {
/* 505 */           boolean agg_isNull98 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 506 */           double agg_value134 = agg_isNull98 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 507 */           if (!agg_isNull98) {
/* 508 */             agg_isNull93 = false;
/* 509 */             agg_value129 = agg_value134;
/* 510 */           }
/* 511 */         }
/* 512 */         boolean agg_isNull100 = true;
/* 513 */         double agg_value136 = -1.0;
/* 514 */
/* 515 */         boolean agg_isNull102 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 516 */         double agg_value138 = agg_isNull102 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 517 */         boolean agg_isNull101 = agg_isNull102;
/* 518 */         double agg_value137 = agg_value138;
/* 519 */         if (agg_isNull101) {
/* 520 */           if (!agg_isNull61) {
/* 521 */             agg_isNull101 = false;
/* 522 */             agg_value137 = agg_value97;
/* 523 */           }
/* 524 */         }
/* 525 */
/* 526 */         if (!inputadapter_isNull14) {
/* 527 */           agg_isNull100 = false; // resultCode could change nullability.
/* 528 */           agg_value136 = agg_value137 + inputadapter_value14;
/* 529 */
/* 530 */         }
/* 531 */         boolean agg_isNull99 = agg_isNull100;
/* 532 */         double agg_value135 = agg_value136;
/* 533 */         if (agg_isNull99) {
/* 534 */           boolean agg_isNull104 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 535 */           double agg_value140 = agg_isNull104 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 536 */           if (!agg_isNull104) {
/* 537 */             agg_isNull99 = false;
/* 538 */             agg_value135 = agg_value140;
/* 539 */           }
/* 540 */         }
/* 541 */         boolean agg_isNull106 = true;
/* 542 */         double agg_value142 = -1.0;
/* 543 */
/* 544 */         boolean agg_isNull108 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 545 */         double agg_value144 = agg_isNull108 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 546 */         boolean agg_isNull107 = agg_isNull108;
/* 547 */         double agg_value143 = agg_value144;
/* 548 */         if (agg_isNull107) {
/* 549 */           if (!agg_isNull61) {
/* 550 */             agg_isNull107 = false;
/* 551 */             agg_value143 = agg_value97;
/* 552 */           }
/* 553 */         }
/* 554 */
/* 555 */         if (!inputadapter_isNull15) {
/* 556 */           agg_isNull106 = false; // resultCode could change nullability.
/* 557 */           agg_value142 = agg_value143 + inputadapter_value15;
/* 558 */
/* 559 */         }
/* 560 */         boolean agg_isNull105 = agg_isNull106;
/* 561 */         double agg_value141 = agg_value142;
/* 562 */         if (agg_isNull105) {
/* 563 */           boolean agg_isNull110 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 564 */           double agg_value146 = agg_isNull110 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 565 */           if (!agg_isNull110) {
/* 566 */             agg_isNull105 = false;
/* 567 */             agg_value141 = agg_value146;
/* 568 */           }
/* 569 */         }
/* 570 */         boolean agg_isNull112 = true;
/* 571 */         double agg_value148 = -1.0;
/* 572 */
/* 573 */         boolean agg_isNull114 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 574 */         double agg_value150 = agg_isNull114 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 575 */         boolean agg_isNull113 = agg_isNull114;
/* 576 */         double agg_value149 = agg_value150;
/* 577 */         if (agg_isNull113) {
/* 578 */           if (!agg_isNull61) {
/* 579 */             agg_isNull113 = false;
/* 580 */             agg_value149 = agg_value97;
/* 581 */           }
/* 582 */         }
/* 583 */
/* 584 */         if (!inputadapter_isNull16) {
/* 585 */           agg_isNull112 = false; // resultCode could change nullability.
/* 586 */           agg_value148 = agg_value149 + inputadapter_value16;
/* 587 */
/* 588 */         }
/* 589 */         boolean agg_isNull111 = agg_isNull112;
/* 590 */         double agg_value147 = agg_value148;
/* 591 */         if (agg_isNull111) {
/* 592 */           boolean agg_isNull116 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 593 */           double agg_value152 = agg_isNull116 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 594 */           if (!agg_isNull116) {
/* 595 */             agg_isNull111 = false;
/* 596 */             agg_value147 = agg_value152;
/* 597 */           }
/* 598 */         }
/* 599 */         boolean agg_isNull118 = true;
/* 600 */         double agg_value154 = -1.0;
/* 601 */
/* 602 */         boolean agg_isNull120 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 603 */         double agg_value156 = agg_isNull120 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 604 */         boolean agg_isNull119 = agg_isNull120;
/* 605 */         double agg_value155 = agg_value156;
/* 606 */         if (agg_isNull119) {
/* 607 */           if (!agg_isNull61) {
/* 608 */             agg_isNull119 = false;
/* 609 */             agg_value155 = agg_value97;
/* 610 */           }
/* 611 */         }
/* 612 */
/* 613 */         if (!inputadapter_isNull17) {
/* 614 */           agg_isNull118 = false; // resultCode could change nullability.
/* 615 */           agg_value154 = agg_value155 + inputadapter_value17;
/* 616 */
/* 617 */         }
/* 618 */         boolean agg_isNull117 = agg_isNull118;
/* 619 */         double agg_value153 = agg_value154;
/* 620 */         if (agg_isNull117) {
/* 621 */           boolean agg_isNull122 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 622 */           double agg_value158 = agg_isNull122 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 623 */           if (!agg_isNull122) {
/* 624 */             agg_isNull117 = false;
/* 625 */             agg_value153 = agg_value158;
/* 626 */           }
/* 627 */         }
/* 628 */         boolean agg_isNull124 = true;
/* 629 */         double agg_value160 = -1.0;
/* 630 */
/* 631 */         boolean agg_isNull126 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 632 */         double agg_value162 = agg_isNull126 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 633 */         boolean agg_isNull125 = agg_isNull126;
/* 634 */         double agg_value161 = agg_value162;
/* 635 */         if (agg_isNull125) {
/* 636 */           if (!agg_isNull61) {
/* 637 */             agg_isNull125 = false;
/* 638 */             agg_value161 = agg_value97;
/* 639 */           }
/* 640 */         }
/* 641 */
/* 642 */         if (!inputadapter_isNull18) {
/* 643 */           agg_isNull124 = false; // resultCode could change nullability.
/* 644 */           agg_value160 = agg_value161 + inputadapter_value18;
/* 645 */
/* 646 */         }
/* 647 */         boolean agg_isNull123 = agg_isNull124;
/* 648 */         double agg_value159 = agg_value160;
/* 649 */         if (agg_isNull123) {
/* 650 */           boolean agg_isNull128 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 651 */           double agg_value164 = agg_isNull128 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 652 */           if (!agg_isNull128) {
/* 653 */             agg_isNull123 = false;
/* 654 */             agg_value159 = agg_value164;
/* 655 */           }
/* 656 */         }
/* 657 */         boolean agg_isNull130 = true;
/* 658 */         double agg_value166 = -1.0;
/* 659 */
/* 660 */         boolean agg_isNull132 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 661 */         double agg_value168 = agg_isNull132 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 662 */         boolean agg_isNull131 = agg_isNull132;
/* 663 */         double agg_value167 = agg_value168;
/* 664 */         if (agg_isNull131) {
/* 665 */           if (!agg_isNull61) {
/* 666 */             agg_isNull131 = false;
/* 667 */             agg_value167 = agg_value97;
/* 668 */           }
/* 669 */         }
/* 670 */
/* 671 */         if (!inputadapter_isNull19) {
/* 672 */           agg_isNull130 = false; // resultCode could change nullability.
/* 673 */           agg_value166 = agg_value167 + inputadapter_value19;
/* 674 */
/* 675 */         }
/* 676 */         boolean agg_isNull129 = agg_isNull130;
/* 677 */         double agg_value165 = agg_value166;
/* 678 */         if (agg_isNull129) {
/* 679 */           boolean agg_isNull134 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 680 */           double agg_value170 = agg_isNull134 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 681 */           if (!agg_isNull134) {
/* 682 */             agg_isNull129 = false;
/* 683 */             agg_value165 = agg_value170;
/* 684 */           }
/* 685 */         }
/* 686 */         boolean agg_isNull136 = true;
/* 687 */         double agg_value172 = -1.0;
/* 688 */
/* 689 */         boolean agg_isNull138 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 690 */         double agg_value174 = agg_isNull138 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 691 */         boolean agg_isNull137 = agg_isNull138;
/* 692 */         double agg_value173 = agg_value174;
/* 693 */         if (agg_isNull137) {
/* 694 */           if (!agg_isNull61) {
/* 695 */             agg_isNull137 = false;
/* 696 */             agg_value173 = agg_value97;
/* 697 */           }
/* 698 */         }
/* 699 */
/* 700 */         if (!inputadapter_isNull20) {
/* 701 */           agg_isNull136 = false; // resultCode could change nullability.
/* 702 */           agg_value172 = agg_value173 + inputadapter_value20;
/* 703 */
/* 704 */         }
/* 705 */         boolean agg_isNull135 = agg_isNull136;
/* 706 */         double agg_value171 = agg_value172;
/* 707 */         if (agg_isNull135) {
/* 708 */           boolean agg_isNull140 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 709 */           double agg_value176 = agg_isNull140 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 710 */           if (!agg_isNull140) {
/* 711 */             agg_isNull135 = false;
/* 712 */             agg_value171 = agg_value176;
/* 713 */           }
/* 714 */         }
/* 715 */         boolean agg_isNull142 = true;
/* 716 */         double agg_value178 = -1.0;
/* 717 */
/* 718 */         boolean agg_isNull144 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 719 */         double agg_value180 = agg_isNull144 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 720 */         boolean agg_isNull143 = agg_isNull144;
/* 721 */         double agg_value179 = agg_value180;
/* 722 */         if (agg_isNull143) {
/* 723 */           if (!agg_isNull61) {
/* 724 */             agg_isNull143 = false;
/* 725 */             agg_value179 = agg_value97;
/* 726 */           }
/* 727 */         }
/* 728 */
/* 729 */         if (!inputadapter_isNull21) {
/* 730 */           agg_isNull142 = false; // resultCode could change nullability.
/* 731 */           agg_value178 = agg_value179 + inputadapter_value21;
/* 732 */
/* 733 */         }
/* 734 */         boolean agg_isNull141 = agg_isNull142;
/* 735 */         double agg_value177 = agg_value178;
/* 736 */         if (agg_isNull141) {
/* 737 */           boolean agg_isNull146 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 738 */           double agg_value182 = agg_isNull146 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 739 */           if (!agg_isNull146) {
/* 740 */             agg_isNull141 = false;
/* 741 */             agg_value177 = agg_value182;
/* 742 */           }
/* 743 */         }
/* 744 */         boolean agg_isNull148 = true;
/* 745 */         double agg_value184 = -1.0;
/* 746 */
/* 747 */         boolean agg_isNull150 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 748 */         double agg_value186 = agg_isNull150 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 749 */         boolean agg_isNull149 = agg_isNull150;
/* 750 */         double agg_value185 = agg_value186;
/* 751 */         if (agg_isNull149) {
/* 752 */           if (!agg_isNull61) {
/* 753 */             agg_isNull149 = false;
/* 754 */             agg_value185 = agg_value97;
/* 755 */           }
/* 756 */         }
/* 757 */
/* 758 */         if (!inputadapter_isNull22) {
/* 759 */           agg_isNull148 = false; // resultCode could change nullability.
/* 760 */           agg_value184 = agg_value185 + inputadapter_value22;
/* 761 */
/* 762 */         }
/* 763 */         boolean agg_isNull147 = agg_isNull148;
/* 764 */         double agg_value183 = agg_value184;
/* 765 */         if (agg_isNull147) {
/* 766 */           boolean agg_isNull152 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 767 */           double agg_value188 = agg_isNull152 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 768 */           if (!agg_isNull152) {
/* 769 */             agg_isNull147 = false;
/* 770 */             agg_value183 = agg_value188;
/* 771 */           }
/* 772 */         }
/* 773 */         boolean agg_isNull154 = true;
/* 774 */         double agg_value190 = -1.0;
/* 775 */
/* 776 */         boolean agg_isNull156 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 777 */         double agg_value192 = agg_isNull156 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 778 */         boolean agg_isNull155 = agg_isNull156;
/* 779 */         double agg_value191 = agg_value192;
/* 780 */         if (agg_isNull155) {
/* 781 */           if (!agg_isNull61) {
/* 782 */             agg_isNull155 = false;
/* 783 */             agg_value191 = agg_value97;
/* 784 */           }
/* 785 */         }
/* 786 */
/* 787 */         if (!inputadapter_isNull23) {
/* 788 */           agg_isNull154 = false; // resultCode could change nullability.
/* 789 */           agg_value190 = agg_value191 + inputadapter_value23;
/* 790 */
/* 791 */         }
/* 792 */         boolean agg_isNull153 = agg_isNull154;
/* 793 */         double agg_value189 = agg_value190;
/* 794 */         if (agg_isNull153) {
/* 795 */           boolean agg_isNull158 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 796 */           double agg_value194 = agg_isNull158 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 797 */           if (!agg_isNull158) {
/* 798 */             agg_isNull153 = false;
/* 799 */             agg_value189 = agg_value194;
/* 800 */           }
/* 801 */         }
/* 802 */         boolean agg_isNull160 = true;
/* 803 */         double agg_value196 = -1.0;
/* 804 */
/* 805 */         boolean agg_isNull162 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 806 */         double agg_value198 = agg_isNull162 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 807 */         boolean agg_isNull161 = agg_isNull162;
/* 808 */         double agg_value197 = agg_value198;
/* 809 */         if (agg_isNull161) {
/* 810 */           if (!agg_isNull61) {
/* 811 */             agg_isNull161 = false;
/* 812 */             agg_value197 = agg_value97;
/* 813 */           }
/* 814 */         }
/* 815 */
/* 816 */         if (!inputadapter_isNull24) {
/* 817 */           agg_isNull160 = false; // resultCode could change nullability.
/* 818 */           agg_value196 = agg_value197 + inputadapter_value24;
/* 819 */
/* 820 */         }
/* 821 */         boolean agg_isNull159 = agg_isNull160;
/* 822 */         double agg_value195 = agg_value196;
/* 823 */         if (agg_isNull159) {
/* 824 */           boolean agg_isNull164 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 825 */           double agg_value200 = agg_isNull164 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 826 */           if (!agg_isNull164) {
/* 827 */             agg_isNull159 = false;
/* 828 */             agg_value195 = agg_value200;
/* 829 */           }
/* 830 */         }
/* 831 */         boolean agg_isNull166 = true;
/* 832 */         double agg_value202 = -1.0;
/* 833 */
/* 834 */         boolean agg_isNull168 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 835 */         double agg_value204 = agg_isNull168 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 836 */         boolean agg_isNull167 = agg_isNull168;
/* 837 */         double agg_value203 = agg_value204;
/* 838 */         if (agg_isNull167) {
/* 839 */           if (!agg_isNull61) {
/* 840 */             agg_isNull167 = false;
/* 841 */             agg_value203 = agg_value97;
/* 842 */           }
/* 843 */         }
/* 844 */
/* 845 */         if (!inputadapter_isNull25) {
/* 846 */           agg_isNull166 = false; // resultCode could change nullability.
/* 847 */           agg_value202 = agg_value203 + inputadapter_value25;
/* 848 */
/* 849 */         }
/* 850 */         boolean agg_isNull165 = agg_isNull166;
/* 851 */         double agg_value201 = agg_value202;
/* 852 */         if (agg_isNull165) {
/* 853 */           boolean agg_isNull170 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 854 */           double agg_value206 = agg_isNull170 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 855 */           if (!agg_isNull170) {
/* 856 */             agg_isNull165 = false;
/* 857 */             agg_value201 = agg_value206;
/* 858 */           }
/* 859 */         }
/* 860 */         boolean agg_isNull172 = true;
/* 861 */         double agg_value208 = -1.0;
/* 862 */
/* 863 */         boolean agg_isNull174 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 864 */         double agg_value210 = agg_isNull174 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 865 */         boolean agg_isNull173 = agg_isNull174;
/* 866 */         double agg_value209 = agg_value210;
/* 867 */         if (agg_isNull173) {
/* 868 */           if (!agg_isNull61) {
/* 869 */             agg_isNull173 = false;
/* 870 */             agg_value209 = agg_value97;
/* 871 */           }
/* 872 */         }
/* 873 */
/* 874 */         if (!inputadapter_isNull26) {
/* 875 */           agg_isNull172 = false; // resultCode could change nullability.
/* 876 */           agg_value208 = agg_value209 + inputadapter_value26;
/* 877 */
/* 878 */         }
/* 879 */         boolean agg_isNull171 = agg_isNull172;
/* 880 */         double agg_value207 = agg_value208;
/* 881 */         if (agg_isNull171) {
/* 882 */           boolean agg_isNull176 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 883 */           double agg_value212 = agg_isNull176 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 884 */           if (!agg_isNull176) {
/* 885 */             agg_isNull171 = false;
/* 886 */             agg_value207 = agg_value212;
/* 887 */           }
/* 888 */         }
/* 889 */         boolean agg_isNull178 = true;
/* 890 */         double agg_value214 = -1.0;
/* 891 */
/* 892 */         boolean agg_isNull180 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 893 */         double agg_value216 = agg_isNull180 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 894 */         boolean agg_isNull179 = agg_isNull180;
/* 895 */         double agg_value215 = agg_value216;
/* 896 */         if (agg_isNull179) {
/* 897 */           if (!agg_isNull61) {
/* 898 */             agg_isNull179 = false;
/* 899 */             agg_value215 = agg_value97;
/* 900 */           }
/* 901 */         }
/* 902 */
/* 903 */         if (!inputadapter_isNull27) {
/* 904 */           agg_isNull178 = false; // resultCode could change nullability.
/* 905 */           agg_value214 = agg_value215 + inputadapter_value27;
/* 906 */
/* 907 */         }
/* 908 */         boolean agg_isNull177 = agg_isNull178;
/* 909 */         double agg_value213 = agg_value214;
/* 910 */         if (agg_isNull177) {
/* 911 */           boolean agg_isNull182 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 912 */           double agg_value218 = agg_isNull182 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 913 */           if (!agg_isNull182) {
/* 914 */             agg_isNull177 = false;
/* 915 */             agg_value213 = agg_value218;
/* 916 */           }
/* 917 */         }
/* 918 */         boolean agg_isNull184 = true;
/* 919 */         double agg_value220 = -1.0;
/* 920 */
/* 921 */         boolean agg_isNull186 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 922 */         double agg_value222 = agg_isNull186 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 923 */         boolean agg_isNull185 = agg_isNull186;
/* 924 */         double agg_value221 = agg_value222;
/* 925 */         if (agg_isNull185) {
/* 926 */           if (!agg_isNull61) {
/* 927 */             agg_isNull185 = false;
/* 928 */             agg_value221 = agg_value97;
/* 929 */           }
/* 930 */         }
/* 931 */
/* 932 */         if (!inputadapter_isNull28) {
/* 933 */           agg_isNull184 = false; // resultCode could change nullability.
/* 934 */           agg_value220 = agg_value221 + inputadapter_value28;
/* 935 */
/* 936 */         }
/* 937 */         boolean agg_isNull183 = agg_isNull184;
/* 938 */         double agg_value219 = agg_value220;
/* 939 */         if (agg_isNull183) {
/* 940 */           boolean agg_isNull188 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 941 */           double agg_value224 = agg_isNull188 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 942 */           if (!agg_isNull188) {
/* 943 */             agg_isNull183 = false;
/* 944 */             agg_value219 = agg_value224;
/* 945 */           }
/* 946 */         }
/* 947 */         boolean agg_isNull190 = true;
/* 948 */         double agg_value226 = -1.0;
/* 949 */
/* 950 */         boolean agg_isNull192 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 951 */         double agg_value228 = agg_isNull192 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 952 */         boolean agg_isNull191 = agg_isNull192;
/* 953 */         double agg_value227 = agg_value228;
/* 954 */         if (agg_isNull191) {
/* 955 */           if (!agg_isNull61) {
/* 956 */             agg_isNull191 = false;
/* 957 */             agg_value227 = agg_value97;
/* 958 */           }
/* 959 */         }
/* 960 */
/* 961 */         if (!inputadapter_isNull29) {
/* 962 */           agg_isNull190 = false; // resultCode could change nullability.
/* 963 */           agg_value226 = agg_value227 + inputadapter_value29;
/* 964 */
/* 965 */         }
/* 966 */         boolean agg_isNull189 = agg_isNull190;
/* 967 */         double agg_value225 = agg_value226;
/* 968 */         if (agg_isNull189) {
/* 969 */           boolean agg_isNull194 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 970 */           double agg_value230 = agg_isNull194 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 971 */           if (!agg_isNull194) {
/* 972 */             agg_isNull189 = false;
/* 973 */             agg_value225 = agg_value230;
/* 974 */           }
/* 975 */         }
/* 976 */         boolean agg_isNull196 = true;
/* 977 */         double agg_value232 = -1.0;
/* 978 */
/* 979 */         boolean agg_isNull198 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 980 */         double agg_value234 = agg_isNull198 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 981 */         boolean agg_isNull197 = agg_isNull198;
/* 982 */         double agg_value233 = agg_value234;
/* 983 */         if (agg_isNull197) {
/* 984 */           if (!agg_isNull61) {
/* 985 */             agg_isNull197 = false;
/* 986 */             agg_value233 = agg_value97;
/* 987 */           }
/* 988 */         }
/* 989 */
/* 990 */         if (!inputadapter_isNull30) {
/* 991 */           agg_isNull196 = false; // resultCode could change nullability.
/* 992 */           agg_value232 = agg_value233 + inputadapter_value30;
/* 993 */
/* 994 */         }
/* 995 */         boolean agg_isNull195 = agg_isNull196;
/* 996 */         double agg_value231 = agg_value232;
/* 997 */         if (agg_isNull195) {
/* 998 */           boolean agg_isNull200 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 999 */           double agg_value236 = agg_isNull200 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 1000 */           if (!agg_isNull200) {
/* 1001 */             agg_isNull195 = false;
/* 1002 */             agg_value231 = agg_value236;
/* 1003 */           }
/* 1004 */         }
/* 1005 */         boolean agg_isNull202 = true;
/* 1006 */         double agg_value238 = -1.0;
/* 1007 */
/* 1008 */         boolean agg_isNull204 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 1009 */         double agg_value240 = agg_isNull204 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 1010 */         boolean agg_isNull203 = agg_isNull204;
/* 1011 */         double agg_value239 = agg_value240;
/* 1012 */         if (agg_isNull203) {
/* 1013 */           if (!agg_isNull61) {
/* 1014 */             agg_isNull203 = false;
/* 1015 */             agg_value239 = agg_value97;
/* 1016 */           }
/* 1017 */         }
/* 1018 */
/* 1019 */         if (!inputadapter_isNull31) {
/* 1020 */           agg_isNull202 = false; // resultCode could change nullability.
/* 1021 */           agg_value238 = agg_value239 + inputadapter_value31;
/* 1022 */
/* 1023 */         }
/* 1024 */         boolean agg_isNull201 = agg_isNull202;
/* 1025 */         double agg_value237 = agg_value238;
/* 1026 */         if (agg_isNull201) {
/* 1027 */           boolean agg_isNull206 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 1028 */           double agg_value242 = agg_isNull206 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 1029 */           if (!agg_isNull206) {
/* 1030 */             agg_isNull201 = false;
/* 1031 */             agg_value237 = agg_value242;
/* 1032 */           }
/* 1033 */         }
/* 1034 */         boolean agg_isNull208 = true;
/* 1035 */         double agg_value244 = -1.0;
/* 1036 */
/* 1037 */         boolean agg_isNull210 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 1038 */         double agg_value246 = agg_isNull210 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(24));
/* 1039 */         boolean agg_isNull209 = agg_isNull210;
/* 1040 */         double agg_value245 = agg_value246;
/* 1041 */         if (agg_isNull209) {
/* 1042 */           if (!agg_isNull61) {
/* 1043 */             agg_isNull209 = false;
/* 1044 */             agg_value245 = agg_value97;
/* 1045 */           }
/* 1046 */         }
/* 1047 */
/* 1048 */         if (!inputadapter_isNull32) {
/* 1049 */           agg_isNull208 = false; // resultCode could change nullability.
/* 1050 */           agg_value244 = agg_value245 + inputadapter_value32;
/* 1051 */
/* 1052 */         }
/* 1053 */         boolean agg_isNull207 = agg_isNull208;
/* 1054 */         double agg_value243 = agg_value244;
/* 1055 */         if (agg_isNull207) {
/* 1056 */           boolean agg_isNull212 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 1057 */           double agg_value248 = agg_isNull212 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(24));
/* 1058 */           if (!agg_isNull212) {
/* 1059 */             agg_isNull207 = false;
/* 1060 */             agg_value243 = agg_value248;
/* 1061 */           }
/* 1062 */         }
/* 1063 */         boolean agg_isNull214 = true;
/* 1064 */         double agg_value250 = -1.0;
/* 1065 */
/* 1066 */         boolean agg_isNull216 = agg_unsafeRowAggBuffer.isNullAt(25);
/* 1067 */         double agg_value252 = agg_isNull216 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(25));
/* 1068 */         boolean agg_isNull215 = agg_isNull216;
/* 1069 */         double agg_value251 = agg_value252;
/* 1070 */         if (agg_isNull215) {
/* 1071 */           if (!agg_isNull61) {
/* 1072 */             agg_isNull215 = false;
/* 1073 */             agg_value251 = agg_value97;
/* 1074 */           }
/* 1075 */         }
/* 1076 */
/* 1077 */         if (!inputadapter_isNull33) {
/* 1078 */           agg_isNull214 = false; // resultCode could change nullability.
/* 1079 */           agg_value250 = agg_value251 + inputadapter_value33;
/* 1080 */
/* 1081 */         }
/* 1082 */         boolean agg_isNull213 = agg_isNull214;
/* 1083 */         double agg_value249 = agg_value250;
/* 1084 */         if (agg_isNull213) {
/* 1085 */           boolean agg_isNull218 = agg_unsafeRowAggBuffer.isNullAt(25);
/* 1086 */           double agg_value254 = agg_isNull218 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(25));
/* 1087 */           if (!agg_isNull218) {
/* 1088 */             agg_isNull213 = false;
/* 1089 */             agg_value249 = agg_value254;
/* 1090 */           }
/* 1091 */         }
/* 1092 */         boolean agg_isNull220 = true;
/* 1093 */         double agg_value256 = -1.0;
/* 1094 */
/* 1095 */         boolean agg_isNull222 = agg_unsafeRowAggBuffer.isNullAt(26);
/* 1096 */         double agg_value258 = agg_isNull222 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(26));
/* 1097 */         boolean agg_isNull221 = agg_isNull222;
/* 1098 */         double agg_value257 = agg_value258;
/* 1099 */         if (agg_isNull221) {
/* 1100 */           if (!agg_isNull61) {
/* 1101 */             agg_isNull221 = false;
/* 1102 */             agg_value257 = agg_value97;
/* 1103 */           }
/* 1104 */         }
/* 1105 */
/* 1106 */         if (!inputadapter_isNull34) {
/* 1107 */           agg_isNull220 = false; // resultCode could change nullability.
/* 1108 */           agg_value256 = agg_value257 + inputadapter_value34;
/* 1109 */
/* 1110 */         }
/* 1111 */         boolean agg_isNull219 = agg_isNull220;
/* 1112 */         double agg_value255 = agg_value256;
/* 1113 */         if (agg_isNull219) {
/* 1114 */           boolean agg_isNull224 = agg_unsafeRowAggBuffer.isNullAt(26);
/* 1115 */           double agg_value260 = agg_isNull224 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(26));
/* 1116 */           if (!agg_isNull224) {
/* 1117 */             agg_isNull219 = false;
/* 1118 */             agg_value255 = agg_value260;
/* 1119 */           }
/* 1120 */         }
/* 1121 */         boolean agg_isNull226 = true;
/* 1122 */         double agg_value262 = -1.0;
/* 1123 */
/* 1124 */         boolean agg_isNull228 = agg_unsafeRowAggBuffer.isNullAt(27);
/* 1125 */         double agg_value264 = agg_isNull228 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(27));
/* 1126 */         boolean agg_isNull227 = agg_isNull228;
/* 1127 */         double agg_value263 = agg_value264;
/* 1128 */         if (agg_isNull227) {
/* 1129 */           if (!agg_isNull61) {
/* 1130 */             agg_isNull227 = false;
/* 1131 */             agg_value263 = agg_value97;
/* 1132 */           }
/* 1133 */         }
/* 1134 */
/* 1135 */         if (!inputadapter_isNull35) {
/* 1136 */           agg_isNull226 = false; // resultCode could change nullability.
/* 1137 */           agg_value262 = agg_value263 + inputadapter_value35;
/* 1138 */
/* 1139 */         }
/* 1140 */         boolean agg_isNull225 = agg_isNull226;
/* 1141 */         double agg_value261 = agg_value262;
/* 1142 */         if (agg_isNull225) {
/* 1143 */           boolean agg_isNull230 = agg_unsafeRowAggBuffer.isNullAt(27);
/* 1144 */           double agg_value266 = agg_isNull230 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(27));
/* 1145 */           if (!agg_isNull230) {
/* 1146 */             agg_isNull225 = false;
/* 1147 */             agg_value261 = agg_value266;
/* 1148 */           }
/* 1149 */         }
/* 1150 */         boolean agg_isNull232 = true;
/* 1151 */         double agg_value268 = -1.0;
/* 1152 */
/* 1153 */         boolean agg_isNull234 = agg_unsafeRowAggBuffer.isNullAt(28);
/* 1154 */         double agg_value270 = agg_isNull234 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(28));
/* 1155 */         boolean agg_isNull233 = agg_isNull234;
/* 1156 */         double agg_value269 = agg_value270;
/* 1157 */         if (agg_isNull233) {
/* 1158 */           if (!agg_isNull61) {
/* 1159 */             agg_isNull233 = false;
/* 1160 */             agg_value269 = agg_value97;
/* 1161 */           }
/* 1162 */         }
/* 1163 */
/* 1164 */         if (!inputadapter_isNull36) {
/* 1165 */           agg_isNull232 = false; // resultCode could change nullability.
/* 1166 */           agg_value268 = agg_value269 + inputadapter_value36;
/* 1167 */
/* 1168 */         }
/* 1169 */         boolean agg_isNull231 = agg_isNull232;
/* 1170 */         double agg_value267 = agg_value268;
/* 1171 */         if (agg_isNull231) {
/* 1172 */           boolean agg_isNull236 = agg_unsafeRowAggBuffer.isNullAt(28);
/* 1173 */           double agg_value272 = agg_isNull236 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(28));
/* 1174 */           if (!agg_isNull236) {
/* 1175 */             agg_isNull231 = false;
/* 1176 */             agg_value267 = agg_value272;
/* 1177 */           }
/* 1178 */         }
/* 1179 */         boolean agg_isNull238 = true;
/* 1180 */         double agg_value274 = -1.0;
/* 1181 */
/* 1182 */         boolean agg_isNull240 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 1183 */         double agg_value276 = agg_isNull240 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(29));
/* 1184 */         boolean agg_isNull239 = agg_isNull240;
/* 1185 */         double agg_value275 = agg_value276;
/* 1186 */         if (agg_isNull239) {
/* 1187 */           if (!agg_isNull61) {
/* 1188 */             agg_isNull239 = false;
/* 1189 */             agg_value275 = agg_value97;
/* 1190 */           }
/* 1191 */         }
/* 1192 */
/* 1193 */         if (!inputadapter_isNull37) {
/* 1194 */           agg_isNull238 = false; // resultCode could change nullability.
/* 1195 */           agg_value274 = agg_value275 + inputadapter_value37;
/* 1196 */
/* 1197 */         }
/* 1198 */         boolean agg_isNull237 = agg_isNull238;
/* 1199 */         double agg_value273 = agg_value274;
/* 1200 */         if (agg_isNull237) {
/* 1201 */           boolean agg_isNull242 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 1202 */           double agg_value278 = agg_isNull242 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(29));
/* 1203 */           if (!agg_isNull242) {
/* 1204 */             agg_isNull237 = false;
/* 1205 */             agg_value273 = agg_value278;
/* 1206 */           }
/* 1207 */         }
/* 1208 */         boolean agg_isNull244 = true;
/* 1209 */         double agg_value280 = -1.0;
/* 1210 */
/* 1211 */         boolean agg_isNull246 = agg_unsafeRowAggBuffer.isNullAt(30);
/* 1212 */         double agg_value282 = agg_isNull246 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(30));
/* 1213 */         boolean agg_isNull245 = agg_isNull246;
/* 1214 */         double agg_value281 = agg_value282;
/* 1215 */         if (agg_isNull245) {
/* 1216 */           if (!agg_isNull61) {
/* 1217 */             agg_isNull245 = false;
/* 1218 */             agg_value281 = agg_value97;
/* 1219 */           }
/* 1220 */         }
/* 1221 */
/* 1222 */         if (!inputadapter_isNull38) {
/* 1223 */           agg_isNull244 = false; // resultCode could change nullability.
/* 1224 */           agg_value280 = agg_value281 + inputadapter_value38;
/* 1225 */
/* 1226 */         }
/* 1227 */         boolean agg_isNull243 = agg_isNull244;
/* 1228 */         double agg_value279 = agg_value280;
/* 1229 */         if (agg_isNull243) {
/* 1230 */           boolean agg_isNull248 = agg_unsafeRowAggBuffer.isNullAt(30);
/* 1231 */           double agg_value284 = agg_isNull248 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(30));
/* 1232 */           if (!agg_isNull248) {
/* 1233 */             agg_isNull243 = false;
/* 1234 */             agg_value279 = agg_value284;
/* 1235 */           }
/* 1236 */         }
/* 1237 */         boolean agg_isNull250 = true;
/* 1238 */         double agg_value286 = -1.0;
/* 1239 */
/* 1240 */         boolean agg_isNull252 = agg_unsafeRowAggBuffer.isNullAt(31);
/* 1241 */         double agg_value288 = agg_isNull252 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(31));
/* 1242 */         boolean agg_isNull251 = agg_isNull252;
/* 1243 */         double agg_value287 = agg_value288;
/* 1244 */         if (agg_isNull251) {
/* 1245 */           if (!agg_isNull61) {
/* 1246 */             agg_isNull251 = false;
/* 1247 */             agg_value287 = agg_value97;
/* 1248 */           }
/* 1249 */         }
/* 1250 */
/* 1251 */         if (!inputadapter_isNull39) {
/* 1252 */           agg_isNull250 = false; // resultCode could change nullability.
/* 1253 */           agg_value286 = agg_value287 + inputadapter_value39;
/* 1254 */
/* 1255 */         }
/* 1256 */         boolean agg_isNull249 = agg_isNull250;
/* 1257 */         double agg_value285 = agg_value286;
/* 1258 */         if (agg_isNull249) {
/* 1259 */           boolean agg_isNull254 = agg_unsafeRowAggBuffer.isNullAt(31);
/* 1260 */           double agg_value290 = agg_isNull254 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(31));
/* 1261 */           if (!agg_isNull254) {
/* 1262 */             agg_isNull249 = false;
/* 1263 */             agg_value285 = agg_value290;
/* 1264 */           }
/* 1265 */         }
/* 1266 */         boolean agg_isNull256 = true;
/* 1267 */         double agg_value292 = -1.0;
/* 1268 */
/* 1269 */         boolean agg_isNull258 = agg_unsafeRowAggBuffer.isNullAt(32);
/* 1270 */         double agg_value294 = agg_isNull258 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(32));
/* 1271 */         boolean agg_isNull257 = agg_isNull258;
/* 1272 */         double agg_value293 = agg_value294;
/* 1273 */         if (agg_isNull257) {
/* 1274 */           if (!agg_isNull61) {
/* 1275 */             agg_isNull257 = false;
/* 1276 */             agg_value293 = agg_value97;
/* 1277 */           }
/* 1278 */         }
/* 1279 */
/* 1280 */         if (!inputadapter_isNull40) {
/* 1281 */           agg_isNull256 = false; // resultCode could change nullability.
/* 1282 */           agg_value292 = agg_value293 + inputadapter_value40;
/* 1283 */
/* 1284 */         }
/* 1285 */         boolean agg_isNull255 = agg_isNull256;
/* 1286 */         double agg_value291 = agg_value292;
/* 1287 */         if (agg_isNull255) {
/* 1288 */           boolean agg_isNull260 = agg_unsafeRowAggBuffer.isNullAt(32);
/* 1289 */           double agg_value296 = agg_isNull260 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(32));
/* 1290 */           if (!agg_isNull260) {
/* 1291 */             agg_isNull255 = false;
/* 1292 */             agg_value291 = agg_value296;
/* 1293 */           }
/* 1294 */         }
/* 1295 */         boolean agg_isNull262 = true;
/* 1296 */         double agg_value298 = -1.0;
/* 1297 */
/* 1298 */         boolean agg_isNull264 = agg_unsafeRowAggBuffer.isNullAt(33);
/* 1299 */         double agg_value300 = agg_isNull264 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(33));
/* 1300 */         boolean agg_isNull263 = agg_isNull264;
/* 1301 */         double agg_value299 = agg_value300;
/* 1302 */         if (agg_isNull263) {
/* 1303 */           if (!agg_isNull61) {
/* 1304 */             agg_isNull263 = false;
/* 1305 */             agg_value299 = agg_value97;
/* 1306 */           }
/* 1307 */         }
/* 1308 */
/* 1309 */         if (!inputadapter_isNull41) {
/* 1310 */           agg_isNull262 = false; // resultCode could change nullability.
/* 1311 */           agg_value298 = agg_value299 + inputadapter_value41;
/* 1312 */
/* 1313 */         }
/* 1314 */         boolean agg_isNull261 = agg_isNull262;
/* 1315 */         double agg_value297 = agg_value298;
/* 1316 */         if (agg_isNull261) {
/* 1317 */           boolean agg_isNull266 = agg_unsafeRowAggBuffer.isNullAt(33);
/* 1318 */           double agg_value302 = agg_isNull266 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(33));
/* 1319 */           if (!agg_isNull266) {
/* 1320 */             agg_isNull261 = false;
/* 1321 */             agg_value297 = agg_value302;
/* 1322 */           }
/* 1323 */         }
/* 1324 */         boolean agg_isNull268 = true;
/* 1325 */         double agg_value304 = -1.0;
/* 1326 */
/* 1327 */         boolean agg_isNull270 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 1328 */         double agg_value306 = agg_isNull270 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(34));
/* 1329 */         boolean agg_isNull269 = agg_isNull270;
/* 1330 */         double agg_value305 = agg_value306;
/* 1331 */         if (agg_isNull269) {
/* 1332 */           if (!agg_isNull61) {
/* 1333 */             agg_isNull269 = false;
/* 1334 */             agg_value305 = agg_value97;
/* 1335 */           }
/* 1336 */         }
/* 1337 */
/* 1338 */         if (!inputadapter_isNull42) {
/* 1339 */           agg_isNull268 = false; // resultCode could change nullability.
/* 1340 */           agg_value304 = agg_value305 + inputadapter_value42;
/* 1341 */
/* 1342 */         }
/* 1343 */         boolean agg_isNull267 = agg_isNull268;
/* 1344 */         double agg_value303 = agg_value304;
/* 1345 */         if (agg_isNull267) {
/* 1346 */           boolean agg_isNull272 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 1347 */           double agg_value308 = agg_isNull272 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(34));
/* 1348 */           if (!agg_isNull272) {
/* 1349 */             agg_isNull267 = false;
/* 1350 */             agg_value303 = agg_value308;
/* 1351 */           }
/* 1352 */         }
/* 1353 */         boolean agg_isNull274 = true;
/* 1354 */         double agg_value310 = -1.0;
/* 1355 */
/* 1356 */         boolean agg_isNull276 = agg_unsafeRowAggBuffer.isNullAt(35);
/* 1357 */         double agg_value312 = agg_isNull276 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(35));
/* 1358 */         boolean agg_isNull275 = agg_isNull276;
/* 1359 */         double agg_value311 = agg_value312;
/* 1360 */         if (agg_isNull275) {
/* 1361 */           if (!agg_isNull61) {
/* 1362 */             agg_isNull275 = false;
/* 1363 */             agg_value311 = agg_value97;
/* 1364 */           }
/* 1365 */         }
/* 1366 */
/* 1367 */         if (!inputadapter_isNull43) {
/* 1368 */           agg_isNull274 = false; // resultCode could change nullability.
/* 1369 */           agg_value310 = agg_value311 + inputadapter_value43;
/* 1370 */
/* 1371 */         }
/* 1372 */         boolean agg_isNull273 = agg_isNull274;
/* 1373 */         double agg_value309 = agg_value310;
/* 1374 */         if (agg_isNull273) {
/* 1375 */           boolean agg_isNull278 = agg_unsafeRowAggBuffer.isNullAt(35);
/* 1376 */           double agg_value314 = agg_isNull278 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(35));
/* 1377 */           if (!agg_isNull278) {
/* 1378 */             agg_isNull273 = false;
/* 1379 */             agg_value309 = agg_value314;
/* 1380 */           }
/* 1381 */         }
/* 1382 */         // update unsafe row buffer
/* 1383 */         if (!agg_isNull63) {
/* 1384 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value99);
/* 1385 */         } else {
/* 1386 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 1387 */         }
/* 1388 */
/* 1389 */         if (!agg_isNull69) {
/* 1390 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value105);
/* 1391 */         } else {
/* 1392 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 1393 */         }
/* 1394 */
/* 1395 */         if (!agg_isNull75) {
/* 1396 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value111);
/* 1397 */         } else {
/* 1398 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 1399 */         }
/* 1400 */
/* 1401 */         if (!agg_isNull81) {
/* 1402 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value117);
/* 1403 */         } else {
/* 1404 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 1405 */         }
/* 1406 */
/* 1407 */         if (!agg_isNull87) {
/* 1408 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value123);
/* 1409 */         } else {
/* 1410 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 1411 */         }
/* 1412 */
/* 1413 */         if (!agg_isNull93) {
/* 1414 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value129);
/* 1415 */         } else {
/* 1416 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 1417 */         }
/* 1418 */
/* 1419 */         if (!agg_isNull99) {
/* 1420 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value135);
/* 1421 */         } else {
/* 1422 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 1423 */         }
/* 1424 */
/* 1425 */         if (!agg_isNull105) {
/* 1426 */           agg_unsafeRowAggBuffer.setDouble(7, agg_value141);
/* 1427 */         } else {
/* 1428 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 1429 */         }
/* 1430 */
/* 1431 */         if (!agg_isNull111) {
/* 1432 */           agg_unsafeRowAggBuffer.setDouble(8, agg_value147);
/* 1433 */         } else {
/* 1434 */           agg_unsafeRowAggBuffer.setNullAt(8);
/* 1435 */         }
/* 1436 */
/* 1437 */         if (!agg_isNull117) {
/* 1438 */           agg_unsafeRowAggBuffer.setDouble(9, agg_value153);
/* 1439 */         } else {
/* 1440 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 1441 */         }
/* 1442 */
/* 1443 */         if (!agg_isNull123) {
/* 1444 */           agg_unsafeRowAggBuffer.setDouble(10, agg_value159);
/* 1445 */         } else {
/* 1446 */           agg_unsafeRowAggBuffer.setNullAt(10);
/* 1447 */         }
/* 1448 */
/* 1449 */         if (!agg_isNull129) {
/* 1450 */           agg_unsafeRowAggBuffer.setDouble(11, agg_value165);
/* 1451 */         } else {
/* 1452 */           agg_unsafeRowAggBuffer.setNullAt(11);
/* 1453 */         }
/* 1454 */
/* 1455 */         if (!agg_isNull135) {
/* 1456 */           agg_unsafeRowAggBuffer.setDouble(12, agg_value171);
/* 1457 */         } else {
/* 1458 */           agg_unsafeRowAggBuffer.setNullAt(12);
/* 1459 */         }
/* 1460 */
/* 1461 */         if (!agg_isNull141) {
/* 1462 */           agg_unsafeRowAggBuffer.setDouble(13, agg_value177);
/* 1463 */         } else {
/* 1464 */           agg_unsafeRowAggBuffer.setNullAt(13);
/* 1465 */         }
/* 1466 */
/* 1467 */         if (!agg_isNull147) {
/* 1468 */           agg_unsafeRowAggBuffer.setDouble(14, agg_value183);
/* 1469 */         } else {
/* 1470 */           agg_unsafeRowAggBuffer.setNullAt(14);
/* 1471 */         }
/* 1472 */
/* 1473 */         if (!agg_isNull153) {
/* 1474 */           agg_unsafeRowAggBuffer.setDouble(15, agg_value189);
/* 1475 */         } else {
/* 1476 */           agg_unsafeRowAggBuffer.setNullAt(15);
/* 1477 */         }
/* 1478 */
/* 1479 */         if (!agg_isNull159) {
/* 1480 */           agg_unsafeRowAggBuffer.setDouble(16, agg_value195);
/* 1481 */         } else {
/* 1482 */           agg_unsafeRowAggBuffer.setNullAt(16);
/* 1483 */         }
/* 1484 */
/* 1485 */         if (!agg_isNull165) {
/* 1486 */           agg_unsafeRowAggBuffer.setDouble(17, agg_value201);
/* 1487 */         } else {
/* 1488 */           agg_unsafeRowAggBuffer.setNullAt(17);
/* 1489 */         }
/* 1490 */
/* 1491 */         if (!agg_isNull171) {
/* 1492 */           agg_unsafeRowAggBuffer.setDouble(18, agg_value207);
/* 1493 */         } else {
/* 1494 */           agg_unsafeRowAggBuffer.setNullAt(18);
/* 1495 */         }
/* 1496 */
/* 1497 */         if (!agg_isNull177) {
/* 1498 */           agg_unsafeRowAggBuffer.setDouble(19, agg_value213);
/* 1499 */         } else {
/* 1500 */           agg_unsafeRowAggBuffer.setNullAt(19);
/* 1501 */         }
/* 1502 */
/* 1503 */         if (!agg_isNull183) {
/* 1504 */           agg_unsafeRowAggBuffer.setDouble(20, agg_value219);
/* 1505 */         } else {
/* 1506 */           agg_unsafeRowAggBuffer.setNullAt(20);
/* 1507 */         }
/* 1508 */
/* 1509 */         if (!agg_isNull189) {
/* 1510 */           agg_unsafeRowAggBuffer.setDouble(21, agg_value225);
/* 1511 */         } else {
/* 1512 */           agg_unsafeRowAggBuffer.setNullAt(21);
/* 1513 */         }
/* 1514 */
/* 1515 */         if (!agg_isNull195) {
/* 1516 */           agg_unsafeRowAggBuffer.setDouble(22, agg_value231);
/* 1517 */         } else {
/* 1518 */           agg_unsafeRowAggBuffer.setNullAt(22);
/* 1519 */         }
/* 1520 */
/* 1521 */         if (!agg_isNull201) {
/* 1522 */           agg_unsafeRowAggBuffer.setDouble(23, agg_value237);
/* 1523 */         } else {
/* 1524 */           agg_unsafeRowAggBuffer.setNullAt(23);
/* 1525 */         }
/* 1526 */
/* 1527 */         if (!agg_isNull207) {
/* 1528 */           agg_unsafeRowAggBuffer.setDouble(24, agg_value243);
/* 1529 */         } else {
/* 1530 */           agg_unsafeRowAggBuffer.setNullAt(24);
/* 1531 */         }
/* 1532 */
/* 1533 */         if (!agg_isNull213) {
/* 1534 */           agg_unsafeRowAggBuffer.setDouble(25, agg_value249);
/* 1535 */         } else {
/* 1536 */           agg_unsafeRowAggBuffer.setNullAt(25);
/* 1537 */         }
/* 1538 */
/* 1539 */         if (!agg_isNull219) {
/* 1540 */           agg_unsafeRowAggBuffer.setDouble(26, agg_value255);
/* 1541 */         } else {
/* 1542 */           agg_unsafeRowAggBuffer.setNullAt(26);
/* 1543 */         }
/* 1544 */
/* 1545 */         if (!agg_isNull225) {
/* 1546 */           agg_unsafeRowAggBuffer.setDouble(27, agg_value261);
/* 1547 */         } else {
/* 1548 */           agg_unsafeRowAggBuffer.setNullAt(27);
/* 1549 */         }
/* 1550 */
/* 1551 */         if (!agg_isNull231) {
/* 1552 */           agg_unsafeRowAggBuffer.setDouble(28, agg_value267);
/* 1553 */         } else {
/* 1554 */           agg_unsafeRowAggBuffer.setNullAt(28);
/* 1555 */         }
/* 1556 */
/* 1557 */         if (!agg_isNull237) {
/* 1558 */           agg_unsafeRowAggBuffer.setDouble(29, agg_value273);
/* 1559 */         } else {
/* 1560 */           agg_unsafeRowAggBuffer.setNullAt(29);
/* 1561 */         }
/* 1562 */
/* 1563 */         if (!agg_isNull243) {
/* 1564 */           agg_unsafeRowAggBuffer.setDouble(30, agg_value279);
/* 1565 */         } else {
/* 1566 */           agg_unsafeRowAggBuffer.setNullAt(30);
/* 1567 */         }
/* 1568 */
/* 1569 */         if (!agg_isNull249) {
/* 1570 */           agg_unsafeRowAggBuffer.setDouble(31, agg_value285);
/* 1571 */         } else {
/* 1572 */           agg_unsafeRowAggBuffer.setNullAt(31);
/* 1573 */         }
/* 1574 */
/* 1575 */         if (!agg_isNull255) {
/* 1576 */           agg_unsafeRowAggBuffer.setDouble(32, agg_value291);
/* 1577 */         } else {
/* 1578 */           agg_unsafeRowAggBuffer.setNullAt(32);
/* 1579 */         }
/* 1580 */
/* 1581 */         if (!agg_isNull261) {
/* 1582 */           agg_unsafeRowAggBuffer.setDouble(33, agg_value297);
/* 1583 */         } else {
/* 1584 */           agg_unsafeRowAggBuffer.setNullAt(33);
/* 1585 */         }
/* 1586 */
/* 1587 */         if (!agg_isNull267) {
/* 1588 */           agg_unsafeRowAggBuffer.setDouble(34, agg_value303);
/* 1589 */         } else {
/* 1590 */           agg_unsafeRowAggBuffer.setNullAt(34);
/* 1591 */         }
/* 1592 */
/* 1593 */         if (!agg_isNull273) {
/* 1594 */           agg_unsafeRowAggBuffer.setDouble(35, agg_value309);
/* 1595 */         } else {
/* 1596 */           agg_unsafeRowAggBuffer.setNullAt(35);
/* 1597 */         }
/* 1598 */
/* 1599 */       }
/* 1600 */       if (shouldStop()) return;
/* 1601 */     }
/* 1602 */
/* 1603 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1604 */   }
/* 1605 */
/* 1606 */   protected void processNext() throws java.io.IOException {
/* 1607 */     if (!agg_initAgg) {
/* 1608 */       agg_initAgg = true;
/* 1609 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1610 */       agg_doAggregateWithKeys();
/* 1611 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1612 */     }
/* 1613 */
/* 1614 */     // output the result
/* 1615 */
/* 1616 */     while (agg_mapIter.next()) {
/* 1617 */       wholestagecodegen_numOutputRows.add(1);
/* 1618 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1619 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1620 */
/* 1621 */       boolean agg_isNull279 = agg_aggKey.isNullAt(0);
/* 1622 */       UTF8String agg_value315 = agg_isNull279 ? null : (agg_aggKey.getUTF8String(0));
/* 1623 */       boolean agg_isNull280 = agg_aggKey.isNullAt(1);
/* 1624 */       int agg_value316 = agg_isNull280 ? -1 : (agg_aggKey.getInt(1));
/* 1625 */       boolean agg_isNull281 = agg_aggKey.isNullAt(2);
/* 1626 */       UTF8String agg_value317 = agg_isNull281 ? null : (agg_aggKey.getUTF8String(2));
/* 1627 */       boolean agg_isNull282 = agg_aggKey.isNullAt(3);
/* 1628 */       UTF8String agg_value318 = agg_isNull282 ? null : (agg_aggKey.getUTF8String(3));
/* 1629 */       boolean agg_isNull283 = agg_aggKey.isNullAt(4);
/* 1630 */       UTF8String agg_value319 = agg_isNull283 ? null : (agg_aggKey.getUTF8String(4));
/* 1631 */       boolean agg_isNull284 = agg_aggKey.isNullAt(5);
/* 1632 */       UTF8String agg_value320 = agg_isNull284 ? null : (agg_aggKey.getUTF8String(5));
/* 1633 */       UTF8String agg_value321 = agg_aggKey.getUTF8String(6);
/* 1634 */       boolean agg_isNull286 = agg_aggKey.isNullAt(7);
/* 1635 */       int agg_value322 = agg_isNull286 ? -1 : (agg_aggKey.getInt(7));
/* 1636 */       boolean agg_isNull287 = agg_aggBuffer.isNullAt(0);
/* 1637 */       double agg_value323 = agg_isNull287 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 1638 */       boolean agg_isNull288 = agg_aggBuffer.isNullAt(1);
/* 1639 */       double agg_value324 = agg_isNull288 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 1640 */       boolean agg_isNull289 = agg_aggBuffer.isNullAt(2);
/* 1641 */       double agg_value325 = agg_isNull289 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 1642 */       boolean agg_isNull290 = agg_aggBuffer.isNullAt(3);
/* 1643 */       double agg_value326 = agg_isNull290 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 1644 */       boolean agg_isNull291 = agg_aggBuffer.isNullAt(4);
/* 1645 */       double agg_value327 = agg_isNull291 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 1646 */       boolean agg_isNull292 = agg_aggBuffer.isNullAt(5);
/* 1647 */       double agg_value328 = agg_isNull292 ? -1.0 : (agg_aggBuffer.getDouble(5));
/* 1648 */       boolean agg_isNull293 = agg_aggBuffer.isNullAt(6);
/* 1649 */       double agg_value329 = agg_isNull293 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 1650 */       boolean agg_isNull294 = agg_aggBuffer.isNullAt(7);
/* 1651 */       double agg_value330 = agg_isNull294 ? -1.0 : (agg_aggBuffer.getDouble(7));
/* 1652 */       boolean agg_isNull295 = agg_aggBuffer.isNullAt(8);
/* 1653 */       double agg_value331 = agg_isNull295 ? -1.0 : (agg_aggBuffer.getDouble(8));
/* 1654 */       boolean agg_isNull296 = agg_aggBuffer.isNullAt(9);
/* 1655 */       double agg_value332 = agg_isNull296 ? -1.0 : (agg_aggBuffer.getDouble(9));
/* 1656 */       boolean agg_isNull297 = agg_aggBuffer.isNullAt(10);
/* 1657 */       double agg_value333 = agg_isNull297 ? -1.0 : (agg_aggBuffer.getDouble(10));
/* 1658 */       boolean agg_isNull298 = agg_aggBuffer.isNullAt(11);
/* 1659 */       double agg_value334 = agg_isNull298 ? -1.0 : (agg_aggBuffer.getDouble(11));
/* 1660 */       boolean agg_isNull299 = agg_aggBuffer.isNullAt(12);
/* 1661 */       double agg_value335 = agg_isNull299 ? -1.0 : (agg_aggBuffer.getDouble(12));
/* 1662 */       boolean agg_isNull300 = agg_aggBuffer.isNullAt(13);
/* 1663 */       double agg_value336 = agg_isNull300 ? -1.0 : (agg_aggBuffer.getDouble(13));
/* 1664 */       boolean agg_isNull301 = agg_aggBuffer.isNullAt(14);
/* 1665 */       double agg_value337 = agg_isNull301 ? -1.0 : (agg_aggBuffer.getDouble(14));
/* 1666 */       boolean agg_isNull302 = agg_aggBuffer.isNullAt(15);
/* 1667 */       double agg_value338 = agg_isNull302 ? -1.0 : (agg_aggBuffer.getDouble(15));
/* 1668 */       boolean agg_isNull303 = agg_aggBuffer.isNullAt(16);
/* 1669 */       double agg_value339 = agg_isNull303 ? -1.0 : (agg_aggBuffer.getDouble(16));
/* 1670 */       boolean agg_isNull304 = agg_aggBuffer.isNullAt(17);
/* 1671 */       double agg_value340 = agg_isNull304 ? -1.0 : (agg_aggBuffer.getDouble(17));
/* 1672 */       boolean agg_isNull305 = agg_aggBuffer.isNullAt(18);
/* 1673 */       double agg_value341 = agg_isNull305 ? -1.0 : (agg_aggBuffer.getDouble(18));
/* 1674 */       boolean agg_isNull306 = agg_aggBuffer.isNullAt(19);
/* 1675 */       double agg_value342 = agg_isNull306 ? -1.0 : (agg_aggBuffer.getDouble(19));
/* 1676 */       boolean agg_isNull307 = agg_aggBuffer.isNullAt(20);
/* 1677 */       double agg_value343 = agg_isNull307 ? -1.0 : (agg_aggBuffer.getDouble(20));
/* 1678 */       boolean agg_isNull308 = agg_aggBuffer.isNullAt(21);
/* 1679 */       double agg_value344 = agg_isNull308 ? -1.0 : (agg_aggBuffer.getDouble(21));
/* 1680 */       boolean agg_isNull309 = agg_aggBuffer.isNullAt(22);
/* 1681 */       double agg_value345 = agg_isNull309 ? -1.0 : (agg_aggBuffer.getDouble(22));
/* 1682 */       boolean agg_isNull310 = agg_aggBuffer.isNullAt(23);
/* 1683 */       double agg_value346 = agg_isNull310 ? -1.0 : (agg_aggBuffer.getDouble(23));
/* 1684 */       boolean agg_isNull311 = agg_aggBuffer.isNullAt(24);
/* 1685 */       double agg_value347 = agg_isNull311 ? -1.0 : (agg_aggBuffer.getDouble(24));
/* 1686 */       boolean agg_isNull312 = agg_aggBuffer.isNullAt(25);
/* 1687 */       double agg_value348 = agg_isNull312 ? -1.0 : (agg_aggBuffer.getDouble(25));
/* 1688 */       boolean agg_isNull313 = agg_aggBuffer.isNullAt(26);
/* 1689 */       double agg_value349 = agg_isNull313 ? -1.0 : (agg_aggBuffer.getDouble(26));
/* 1690 */       boolean agg_isNull314 = agg_aggBuffer.isNullAt(27);
/* 1691 */       double agg_value350 = agg_isNull314 ? -1.0 : (agg_aggBuffer.getDouble(27));
/* 1692 */       boolean agg_isNull315 = agg_aggBuffer.isNullAt(28);
/* 1693 */       double agg_value351 = agg_isNull315 ? -1.0 : (agg_aggBuffer.getDouble(28));
/* 1694 */       boolean agg_isNull316 = agg_aggBuffer.isNullAt(29);
/* 1695 */       double agg_value352 = agg_isNull316 ? -1.0 : (agg_aggBuffer.getDouble(29));
/* 1696 */       boolean agg_isNull317 = agg_aggBuffer.isNullAt(30);
/* 1697 */       double agg_value353 = agg_isNull317 ? -1.0 : (agg_aggBuffer.getDouble(30));
/* 1698 */       boolean agg_isNull318 = agg_aggBuffer.isNullAt(31);
/* 1699 */       double agg_value354 = agg_isNull318 ? -1.0 : (agg_aggBuffer.getDouble(31));
/* 1700 */       boolean agg_isNull319 = agg_aggBuffer.isNullAt(32);
/* 1701 */       double agg_value355 = agg_isNull319 ? -1.0 : (agg_aggBuffer.getDouble(32));
/* 1702 */       boolean agg_isNull320 = agg_aggBuffer.isNullAt(33);
/* 1703 */       double agg_value356 = agg_isNull320 ? -1.0 : (agg_aggBuffer.getDouble(33));
/* 1704 */       boolean agg_isNull321 = agg_aggBuffer.isNullAt(34);
/* 1705 */       double agg_value357 = agg_isNull321 ? -1.0 : (agg_aggBuffer.getDouble(34));
/* 1706 */       boolean agg_isNull322 = agg_aggBuffer.isNullAt(35);
/* 1707 */       double agg_value358 = agg_isNull322 ? -1.0 : (agg_aggBuffer.getDouble(35));
/* 1708 */
/* 1709 */       agg_holder1.reset();
/* 1710 */
/* 1711 */       agg_rowWriter1.zeroOutNullBytes();
/* 1712 */
/* 1713 */       if (agg_isNull279) {
/* 1714 */         agg_rowWriter1.setNullAt(0);
/* 1715 */       } else {
/* 1716 */         agg_rowWriter1.write(0, agg_value315);
/* 1717 */       }
/* 1718 */
/* 1719 */       if (agg_isNull280) {
/* 1720 */         agg_rowWriter1.setNullAt(1);
/* 1721 */       } else {
/* 1722 */         agg_rowWriter1.write(1, agg_value316);
/* 1723 */       }
/* 1724 */
/* 1725 */       if (agg_isNull281) {
/* 1726 */         agg_rowWriter1.setNullAt(2);
/* 1727 */       } else {
/* 1728 */         agg_rowWriter1.write(2, agg_value317);
/* 1729 */       }
/* 1730 */
/* 1731 */       if (agg_isNull282) {
/* 1732 */         agg_rowWriter1.setNullAt(3);
/* 1733 */       } else {
/* 1734 */         agg_rowWriter1.write(3, agg_value318);
/* 1735 */       }
/* 1736 */
/* 1737 */       if (agg_isNull283) {
/* 1738 */         agg_rowWriter1.setNullAt(4);
/* 1739 */       } else {
/* 1740 */         agg_rowWriter1.write(4, agg_value319);
/* 1741 */       }
/* 1742 */
/* 1743 */       if (agg_isNull284) {
/* 1744 */         agg_rowWriter1.setNullAt(5);
/* 1745 */       } else {
/* 1746 */         agg_rowWriter1.write(5, agg_value320);
/* 1747 */       }
/* 1748 */
/* 1749 */       agg_rowWriter1.write(6, agg_value321);
/* 1750 */
/* 1751 */       if (agg_isNull286) {
/* 1752 */         agg_rowWriter1.setNullAt(7);
/* 1753 */       } else {
/* 1754 */         agg_rowWriter1.write(7, agg_value322);
/* 1755 */       }
/* 1756 */
/* 1757 */       if (agg_isNull287) {
/* 1758 */         agg_rowWriter1.setNullAt(8);
/* 1759 */       } else {
/* 1760 */         agg_rowWriter1.write(8, agg_value323);
/* 1761 */       }
/* 1762 */
/* 1763 */       if (agg_isNull288) {
/* 1764 */         agg_rowWriter1.setNullAt(9);
/* 1765 */       } else {
/* 1766 */         agg_rowWriter1.write(9, agg_value324);
/* 1767 */       }
/* 1768 */
/* 1769 */       if (agg_isNull289) {
/* 1770 */         agg_rowWriter1.setNullAt(10);
/* 1771 */       } else {
/* 1772 */         agg_rowWriter1.write(10, agg_value325);
/* 1773 */       }
/* 1774 */
/* 1775 */       if (agg_isNull290) {
/* 1776 */         agg_rowWriter1.setNullAt(11);
/* 1777 */       } else {
/* 1778 */         agg_rowWriter1.write(11, agg_value326);
/* 1779 */       }
/* 1780 */
/* 1781 */       if (agg_isNull291) {
/* 1782 */         agg_rowWriter1.setNullAt(12);
/* 1783 */       } else {
/* 1784 */         agg_rowWriter1.write(12, agg_value327);
/* 1785 */       }
/* 1786 */
/* 1787 */       if (agg_isNull292) {
/* 1788 */         agg_rowWriter1.setNullAt(13);
/* 1789 */       } else {
/* 1790 */         agg_rowWriter1.write(13, agg_value328);
/* 1791 */       }
/* 1792 */
/* 1793 */       if (agg_isNull293) {
/* 1794 */         agg_rowWriter1.setNullAt(14);
/* 1795 */       } else {
/* 1796 */         agg_rowWriter1.write(14, agg_value329);
/* 1797 */       }
/* 1798 */
/* 1799 */       if (agg_isNull294) {
/* 1800 */         agg_rowWriter1.setNullAt(15);
/* 1801 */       } else {
/* 1802 */         agg_rowWriter1.write(15, agg_value330);
/* 1803 */       }
/* 1804 */
/* 1805 */       if (agg_isNull295) {
/* 1806 */         agg_rowWriter1.setNullAt(16);
/* 1807 */       } else {
/* 1808 */         agg_rowWriter1.write(16, agg_value331);
/* 1809 */       }
/* 1810 */
/* 1811 */       if (agg_isNull296) {
/* 1812 */         agg_rowWriter1.setNullAt(17);
/* 1813 */       } else {
/* 1814 */         agg_rowWriter1.write(17, agg_value332);
/* 1815 */       }
/* 1816 */
/* 1817 */       if (agg_isNull297) {
/* 1818 */         agg_rowWriter1.setNullAt(18);
/* 1819 */       } else {
/* 1820 */         agg_rowWriter1.write(18, agg_value333);
/* 1821 */       }
/* 1822 */
/* 1823 */       if (agg_isNull298) {
/* 1824 */         agg_rowWriter1.setNullAt(19);
/* 1825 */       } else {
/* 1826 */         agg_rowWriter1.write(19, agg_value334);
/* 1827 */       }
/* 1828 */
/* 1829 */       if (agg_isNull299) {
/* 1830 */         agg_rowWriter1.setNullAt(20);
/* 1831 */       } else {
/* 1832 */         agg_rowWriter1.write(20, agg_value335);
/* 1833 */       }
/* 1834 */
/* 1835 */       if (agg_isNull300) {
/* 1836 */         agg_rowWriter1.setNullAt(21);
/* 1837 */       } else {
/* 1838 */         agg_rowWriter1.write(21, agg_value336);
/* 1839 */       }
/* 1840 */
/* 1841 */       if (agg_isNull301) {
/* 1842 */         agg_rowWriter1.setNullAt(22);
/* 1843 */       } else {
/* 1844 */         agg_rowWriter1.write(22, agg_value337);
/* 1845 */       }
/* 1846 */
/* 1847 */       if (agg_isNull302) {
/* 1848 */         agg_rowWriter1.setNullAt(23);
/* 1849 */       } else {
/* 1850 */         agg_rowWriter1.write(23, agg_value338);
/* 1851 */       }
/* 1852 */
/* 1853 */       if (agg_isNull303) {
/* 1854 */         agg_rowWriter1.setNullAt(24);
/* 1855 */       } else {
/* 1856 */         agg_rowWriter1.write(24, agg_value339);
/* 1857 */       }
/* 1858 */
/* 1859 */       if (agg_isNull304) {
/* 1860 */         agg_rowWriter1.setNullAt(25);
/* 1861 */       } else {
/* 1862 */         agg_rowWriter1.write(25, agg_value340);
/* 1863 */       }
/* 1864 */
/* 1865 */       if (agg_isNull305) {
/* 1866 */         agg_rowWriter1.setNullAt(26);
/* 1867 */       } else {
/* 1868 */         agg_rowWriter1.write(26, agg_value341);
/* 1869 */       }
/* 1870 */
/* 1871 */       if (agg_isNull306) {
/* 1872 */         agg_rowWriter1.setNullAt(27);
/* 1873 */       } else {
/* 1874 */         agg_rowWriter1.write(27, agg_value342);
/* 1875 */       }
/* 1876 */
/* 1877 */       if (agg_isNull307) {
/* 1878 */         agg_rowWriter1.setNullAt(28);
/* 1879 */       } else {
/* 1880 */         agg_rowWriter1.write(28, agg_value343);
/* 1881 */       }
/* 1882 */
/* 1883 */       if (agg_isNull308) {
/* 1884 */         agg_rowWriter1.setNullAt(29);
/* 1885 */       } else {
/* 1886 */         agg_rowWriter1.write(29, agg_value344);
/* 1887 */       }
/* 1888 */
/* 1889 */       if (agg_isNull309) {
/* 1890 */         agg_rowWriter1.setNullAt(30);
/* 1891 */       } else {
/* 1892 */         agg_rowWriter1.write(30, agg_value345);
/* 1893 */       }
/* 1894 */
/* 1895 */       if (agg_isNull310) {
/* 1896 */         agg_rowWriter1.setNullAt(31);
/* 1897 */       } else {
/* 1898 */         agg_rowWriter1.write(31, agg_value346);
/* 1899 */       }
/* 1900 */
/* 1901 */       if (agg_isNull311) {
/* 1902 */         agg_rowWriter1.setNullAt(32);
/* 1903 */       } else {
/* 1904 */         agg_rowWriter1.write(32, agg_value347);
/* 1905 */       }
/* 1906 */
/* 1907 */       if (agg_isNull312) {
/* 1908 */         agg_rowWriter1.setNullAt(33);
/* 1909 */       } else {
/* 1910 */         agg_rowWriter1.write(33, agg_value348);
/* 1911 */       }
/* 1912 */
/* 1913 */       if (agg_isNull313) {
/* 1914 */         agg_rowWriter1.setNullAt(34);
/* 1915 */       } else {
/* 1916 */         agg_rowWriter1.write(34, agg_value349);
/* 1917 */       }
/* 1918 */
/* 1919 */       if (agg_isNull314) {
/* 1920 */         agg_rowWriter1.setNullAt(35);
/* 1921 */       } else {
/* 1922 */         agg_rowWriter1.write(35, agg_value350);
/* 1923 */       }
/* 1924 */
/* 1925 */       if (agg_isNull315) {
/* 1926 */         agg_rowWriter1.setNullAt(36);
/* 1927 */       } else {
/* 1928 */         agg_rowWriter1.write(36, agg_value351);
/* 1929 */       }
/* 1930 */
/* 1931 */       if (agg_isNull316) {
/* 1932 */         agg_rowWriter1.setNullAt(37);
/* 1933 */       } else {
/* 1934 */         agg_rowWriter1.write(37, agg_value352);
/* 1935 */       }
/* 1936 */
/* 1937 */       if (agg_isNull317) {
/* 1938 */         agg_rowWriter1.setNullAt(38);
/* 1939 */       } else {
/* 1940 */         agg_rowWriter1.write(38, agg_value353);
/* 1941 */       }
/* 1942 */
/* 1943 */       if (agg_isNull318) {
/* 1944 */         agg_rowWriter1.setNullAt(39);
/* 1945 */       } else {
/* 1946 */         agg_rowWriter1.write(39, agg_value354);
/* 1947 */       }
/* 1948 */
/* 1949 */       if (agg_isNull319) {
/* 1950 */         agg_rowWriter1.setNullAt(40);
/* 1951 */       } else {
/* 1952 */         agg_rowWriter1.write(40, agg_value355);
/* 1953 */       }
/* 1954 */
/* 1955 */       if (agg_isNull320) {
/* 1956 */         agg_rowWriter1.setNullAt(41);
/* 1957 */       } else {
/* 1958 */         agg_rowWriter1.write(41, agg_value356);
/* 1959 */       }
/* 1960 */
/* 1961 */       if (agg_isNull321) {
/* 1962 */         agg_rowWriter1.setNullAt(42);
/* 1963 */       } else {
/* 1964 */         agg_rowWriter1.write(42, agg_value357);
/* 1965 */       }
/* 1966 */
/* 1967 */       if (agg_isNull322) {
/* 1968 */         agg_rowWriter1.setNullAt(43);
/* 1969 */       } else {
/* 1970 */         agg_rowWriter1.write(43, agg_value358);
/* 1971 */       }
/* 1972 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 1973 */       append(agg_result1);
/* 1974 */
/* 1975 */       if (shouldStop()) return;
/* 1976 */     }
/* 1977 */
/* 1978 */     agg_mapIter.close();
/* 1979 */     if (agg_sorter == null) {
/* 1980 */       agg_hashMap.free();
/* 1981 */     }
/* 1982 */   }
/* 1983 */ }
