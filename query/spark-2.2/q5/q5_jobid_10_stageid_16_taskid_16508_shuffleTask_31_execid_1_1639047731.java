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
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private UnsafeRow agg_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 025 */   private int agg_value12;
/* 026 */   private UnsafeRow agg_result1;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     agg_initAgg = false;
/* 040 */
/* 041 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 042 */
/* 043 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 045 */     inputadapter_input = inputs[0];
/* 046 */     agg_result = new UnsafeRow(3);
/* 047 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 048 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 049 */
/* 050 */     agg_result1 = new UnsafeRow(5);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 052 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 053 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 054 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 059 */     agg_hashMap = agg_plan.createHashMap();
/* 060 */
/* 061 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 062 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 063 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 064 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 065 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 066 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 067 */       int inputadapter_value2 = inputadapter_row.getInt(2);
/* 068 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 069 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 070 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 071 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 072 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 073 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 074 */
/* 075 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 076 */
/* 077 */       UnsafeRow agg_fastAggBuffer = null;
/* 078 */
/* 079 */       if (agg_fastAggBuffer == null) {
/* 080 */         // generate grouping key
/* 081 */         agg_holder.reset();
/* 082 */
/* 083 */         agg_rowWriter.zeroOutNullBytes();
/* 084 */
/* 085 */         if (inputadapter_isNull) {
/* 086 */           agg_rowWriter.setNullAt(0);
/* 087 */         } else {
/* 088 */           agg_rowWriter.write(0, inputadapter_value);
/* 089 */         }
/* 090 */
/* 091 */         if (inputadapter_isNull1) {
/* 092 */           agg_rowWriter.setNullAt(1);
/* 093 */         } else {
/* 094 */           agg_rowWriter.write(1, inputadapter_value1);
/* 095 */         }
/* 096 */
/* 097 */         agg_rowWriter.write(2, inputadapter_value2);
/* 098 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 099 */         agg_value12 = 42;
/* 100 */
/* 101 */         if (!inputadapter_isNull) {
/* 102 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value12);
/* 103 */         }
/* 104 */
/* 105 */         if (!inputadapter_isNull1) {
/* 106 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value12);
/* 107 */         }
/* 108 */
/* 109 */         agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value12);
/* 110 */         if (true) {
/* 111 */           // try to get the buffer from hash map
/* 112 */           agg_unsafeRowAggBuffer =
/* 113 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 114 */         }
/* 115 */         if (agg_unsafeRowAggBuffer == null) {
/* 116 */           if (agg_sorter == null) {
/* 117 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 118 */           } else {
/* 119 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 120 */           }
/* 121 */
/* 122 */           // the hash map had be spilled, it should have enough memory now,
/* 123 */           // try  to allocate buffer again.
/* 124 */           agg_unsafeRowAggBuffer =
/* 125 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 126 */           if (agg_unsafeRowAggBuffer == null) {
/* 127 */             // failed to allocate the first page
/* 128 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 129 */           }
/* 130 */         }
/* 131 */       }
/* 132 */
/* 133 */       if (agg_fastAggBuffer != null) {
/* 134 */         // update fast row
/* 135 */
/* 136 */       } else {
/* 137 */         // update unsafe row
/* 138 */
/* 139 */         // common sub-expressions
/* 140 */
/* 141 */         // evaluate aggregate function
/* 142 */         boolean agg_isNull14 = true;
/* 143 */         double agg_value17 = -1.0;
/* 144 */
/* 145 */         boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 146 */         double agg_value19 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 147 */         boolean agg_isNull15 = agg_isNull16;
/* 148 */         double agg_value18 = agg_value19;
/* 149 */         if (agg_isNull15) {
/* 150 */           boolean agg_isNull17 = false;
/* 151 */           double agg_value20 = -1.0;
/* 152 */           if (!false) {
/* 153 */             agg_value20 = (double) 0;
/* 154 */           }
/* 155 */           if (!agg_isNull17) {
/* 156 */             agg_isNull15 = false;
/* 157 */             agg_value18 = agg_value20;
/* 158 */           }
/* 159 */         }
/* 160 */
/* 161 */         if (!inputadapter_isNull3) {
/* 162 */           agg_isNull14 = false; // resultCode could change nullability.
/* 163 */           agg_value17 = agg_value18 + inputadapter_value3;
/* 164 */
/* 165 */         }
/* 166 */         boolean agg_isNull13 = agg_isNull14;
/* 167 */         double agg_value16 = agg_value17;
/* 168 */         if (agg_isNull13) {
/* 169 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 170 */           double agg_value23 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 171 */           if (!agg_isNull20) {
/* 172 */             agg_isNull13 = false;
/* 173 */             agg_value16 = agg_value23;
/* 174 */           }
/* 175 */         }
/* 176 */         boolean agg_isNull22 = true;
/* 177 */         double agg_value25 = -1.0;
/* 178 */
/* 179 */         boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 180 */         double agg_value27 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 181 */         boolean agg_isNull23 = agg_isNull24;
/* 182 */         double agg_value26 = agg_value27;
/* 183 */         if (agg_isNull23) {
/* 184 */           boolean agg_isNull25 = false;
/* 185 */           double agg_value28 = -1.0;
/* 186 */           if (!false) {
/* 187 */             agg_value28 = (double) 0;
/* 188 */           }
/* 189 */           if (!agg_isNull25) {
/* 190 */             agg_isNull23 = false;
/* 191 */             agg_value26 = agg_value28;
/* 192 */           }
/* 193 */         }
/* 194 */
/* 195 */         if (!inputadapter_isNull4) {
/* 196 */           agg_isNull22 = false; // resultCode could change nullability.
/* 197 */           agg_value25 = agg_value26 + inputadapter_value4;
/* 198 */
/* 199 */         }
/* 200 */         boolean agg_isNull21 = agg_isNull22;
/* 201 */         double agg_value24 = agg_value25;
/* 202 */         if (agg_isNull21) {
/* 203 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 204 */           double agg_value31 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 205 */           if (!agg_isNull28) {
/* 206 */             agg_isNull21 = false;
/* 207 */             agg_value24 = agg_value31;
/* 208 */           }
/* 209 */         }
/* 210 */         boolean agg_isNull30 = true;
/* 211 */         double agg_value33 = -1.0;
/* 212 */
/* 213 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 214 */         double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 215 */         boolean agg_isNull31 = agg_isNull32;
/* 216 */         double agg_value34 = agg_value35;
/* 217 */         if (agg_isNull31) {
/* 218 */           boolean agg_isNull33 = false;
/* 219 */           double agg_value36 = -1.0;
/* 220 */           if (!false) {
/* 221 */             agg_value36 = (double) 0;
/* 222 */           }
/* 223 */           if (!agg_isNull33) {
/* 224 */             agg_isNull31 = false;
/* 225 */             agg_value34 = agg_value36;
/* 226 */           }
/* 227 */         }
/* 228 */
/* 229 */         if (!inputadapter_isNull5) {
/* 230 */           agg_isNull30 = false; // resultCode could change nullability.
/* 231 */           agg_value33 = agg_value34 + inputadapter_value5;
/* 232 */
/* 233 */         }
/* 234 */         boolean agg_isNull29 = agg_isNull30;
/* 235 */         double agg_value32 = agg_value33;
/* 236 */         if (agg_isNull29) {
/* 237 */           boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 238 */           double agg_value39 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 239 */           if (!agg_isNull36) {
/* 240 */             agg_isNull29 = false;
/* 241 */             agg_value32 = agg_value39;
/* 242 */           }
/* 243 */         }
/* 244 */         // update unsafe row buffer
/* 245 */         if (!agg_isNull13) {
/* 246 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value16);
/* 247 */         } else {
/* 248 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 249 */         }
/* 250 */
/* 251 */         if (!agg_isNull21) {
/* 252 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value24);
/* 253 */         } else {
/* 254 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 255 */         }
/* 256 */
/* 257 */         if (!agg_isNull29) {
/* 258 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value32);
/* 259 */         } else {
/* 260 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 261 */         }
/* 262 */
/* 263 */       }
/* 264 */       if (shouldStop()) return;
/* 265 */     }
/* 266 */
/* 267 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 268 */   }
/* 269 */
/* 270 */   protected void processNext() throws java.io.IOException {
/* 271 */     if (!agg_initAgg) {
/* 272 */       agg_initAgg = true;
/* 273 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 274 */       agg_doAggregateWithKeys();
/* 275 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 276 */     }
/* 277 */
/* 278 */     // output the result
/* 279 */
/* 280 */     while (agg_mapIter.next()) {
/* 281 */       wholestagecodegen_numOutputRows.add(1);
/* 282 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 283 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 284 */
/* 285 */       boolean agg_isNull37 = agg_aggKey.isNullAt(0);
/* 286 */       UTF8String agg_value40 = agg_isNull37 ? null : (agg_aggKey.getUTF8String(0));
/* 287 */       boolean agg_isNull38 = agg_aggKey.isNullAt(1);
/* 288 */       UTF8String agg_value41 = agg_isNull38 ? null : (agg_aggKey.getUTF8String(1));
/* 289 */       int agg_value42 = agg_aggKey.getInt(2);
/* 290 */       boolean agg_isNull40 = agg_aggBuffer.isNullAt(0);
/* 291 */       double agg_value43 = agg_isNull40 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 292 */       boolean agg_isNull41 = agg_aggBuffer.isNullAt(1);
/* 293 */       double agg_value44 = agg_isNull41 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 294 */       boolean agg_isNull42 = agg_aggBuffer.isNullAt(2);
/* 295 */       double agg_value45 = agg_isNull42 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 296 */
/* 297 */       agg_holder1.reset();
/* 298 */
/* 299 */       agg_rowWriter1.zeroOutNullBytes();
/* 300 */
/* 301 */       if (agg_isNull37) {
/* 302 */         agg_rowWriter1.setNullAt(0);
/* 303 */       } else {
/* 304 */         agg_rowWriter1.write(0, agg_value40);
/* 305 */       }
/* 306 */
/* 307 */       if (agg_isNull38) {
/* 308 */         agg_rowWriter1.setNullAt(1);
/* 309 */       } else {
/* 310 */         agg_rowWriter1.write(1, agg_value41);
/* 311 */       }
/* 312 */
/* 313 */       if (agg_isNull40) {
/* 314 */         agg_rowWriter1.setNullAt(2);
/* 315 */       } else {
/* 316 */         agg_rowWriter1.write(2, agg_value43);
/* 317 */       }
/* 318 */
/* 319 */       if (agg_isNull41) {
/* 320 */         agg_rowWriter1.setNullAt(3);
/* 321 */       } else {
/* 322 */         agg_rowWriter1.write(3, agg_value44);
/* 323 */       }
/* 324 */
/* 325 */       if (agg_isNull42) {
/* 326 */         agg_rowWriter1.setNullAt(4);
/* 327 */       } else {
/* 328 */         agg_rowWriter1.write(4, agg_value45);
/* 329 */       }
/* 330 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 331 */       append(agg_result1);
/* 332 */
/* 333 */       if (shouldStop()) return;
/* 334 */     }
/* 335 */
/* 336 */     agg_mapIter.close();
/* 337 */     if (agg_sorter == null) {
/* 338 */       agg_hashMap.free();
/* 339 */     }
/* 340 */   }
/* 341 */ }
