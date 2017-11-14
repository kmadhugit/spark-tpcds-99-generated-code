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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value18;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
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
/* 039 */     wholestagecodegen_init_0();
/* 040 */     wholestagecodegen_init_1();
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */   private void wholestagecodegen_init_0() {
/* 045 */     agg_initAgg = false;
/* 046 */
/* 047 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 048 */
/* 049 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 050 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 051 */     inputadapter_input = inputs[0];
/* 052 */     agg_result = new UnsafeRow(8);
/* 053 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 224);
/* 054 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 055 */
/* 056 */     agg_result1 = new UnsafeRow(2);
/* 057 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 058 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 059 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 060 */     filter_result = new UnsafeRow(2);
/* 061 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 066 */     agg_hashMap = agg_plan.createHashMap();
/* 067 */
/* 068 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 069 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 070 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 071 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 072 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 073 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 074 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 075 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 076 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 077 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 078 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 079 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 080 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 081 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 082 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 083 */       UTF8String inputadapter_value6 = inputadapter_isNull6 ? null : (inputadapter_row.getUTF8String(6));
/* 084 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 085 */       UTF8String inputadapter_value7 = inputadapter_isNull7 ? null : (inputadapter_row.getUTF8String(7));
/* 086 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 087 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 088 */
/* 089 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 090 */
/* 091 */       UnsafeRow agg_fastAggBuffer = null;
/* 092 */
/* 093 */       if (agg_fastAggBuffer == null) {
/* 094 */         // generate grouping key
/* 095 */         agg_holder.reset();
/* 096 */
/* 097 */         agg_rowWriter.zeroOutNullBytes();
/* 098 */
/* 099 */         if (inputadapter_isNull) {
/* 100 */           agg_rowWriter.setNullAt(0);
/* 101 */         } else {
/* 102 */           agg_rowWriter.write(0, inputadapter_value);
/* 103 */         }
/* 104 */
/* 105 */         if (inputadapter_isNull1) {
/* 106 */           agg_rowWriter.setNullAt(1);
/* 107 */         } else {
/* 108 */           agg_rowWriter.write(1, inputadapter_value1);
/* 109 */         }
/* 110 */
/* 111 */         if (inputadapter_isNull2) {
/* 112 */           agg_rowWriter.setNullAt(2);
/* 113 */         } else {
/* 114 */           agg_rowWriter.write(2, inputadapter_value2);
/* 115 */         }
/* 116 */
/* 117 */         if (inputadapter_isNull3) {
/* 118 */           agg_rowWriter.setNullAt(3);
/* 119 */         } else {
/* 120 */           agg_rowWriter.write(3, inputadapter_value3);
/* 121 */         }
/* 122 */
/* 123 */         if (inputadapter_isNull4) {
/* 124 */           agg_rowWriter.setNullAt(4);
/* 125 */         } else {
/* 126 */           agg_rowWriter.write(4, inputadapter_value4);
/* 127 */         }
/* 128 */
/* 129 */         if (inputadapter_isNull5) {
/* 130 */           agg_rowWriter.setNullAt(5);
/* 131 */         } else {
/* 132 */           agg_rowWriter.write(5, inputadapter_value5);
/* 133 */         }
/* 134 */
/* 135 */         if (inputadapter_isNull6) {
/* 136 */           agg_rowWriter.setNullAt(6);
/* 137 */         } else {
/* 138 */           agg_rowWriter.write(6, inputadapter_value6);
/* 139 */         }
/* 140 */
/* 141 */         if (inputadapter_isNull7) {
/* 142 */           agg_rowWriter.setNullAt(7);
/* 143 */         } else {
/* 144 */           agg_rowWriter.write(7, inputadapter_value7);
/* 145 */         }
/* 146 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 147 */         agg_value18 = 42;
/* 148 */
/* 149 */         if (!inputadapter_isNull) {
/* 150 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value18);
/* 151 */         }
/* 152 */
/* 153 */         if (!inputadapter_isNull1) {
/* 154 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value18);
/* 155 */         }
/* 156 */
/* 157 */         if (!inputadapter_isNull2) {
/* 158 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value18);
/* 159 */         }
/* 160 */
/* 161 */         if (!inputadapter_isNull3) {
/* 162 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value18);
/* 163 */         }
/* 164 */
/* 165 */         if (!inputadapter_isNull4) {
/* 166 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value18);
/* 167 */         }
/* 168 */
/* 169 */         if (!inputadapter_isNull5) {
/* 170 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value18);
/* 171 */         }
/* 172 */
/* 173 */         if (!inputadapter_isNull6) {
/* 174 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value6.getBaseObject(), inputadapter_value6.getBaseOffset(), inputadapter_value6.numBytes(), agg_value18);
/* 175 */         }
/* 176 */
/* 177 */         if (!inputadapter_isNull7) {
/* 178 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value7.getBaseObject(), inputadapter_value7.getBaseOffset(), inputadapter_value7.numBytes(), agg_value18);
/* 179 */         }
/* 180 */         if (true) {
/* 181 */           // try to get the buffer from hash map
/* 182 */           agg_unsafeRowAggBuffer =
/* 183 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value18);
/* 184 */         }
/* 185 */         if (agg_unsafeRowAggBuffer == null) {
/* 186 */           if (agg_sorter == null) {
/* 187 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 188 */           } else {
/* 189 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 190 */           }
/* 191 */
/* 192 */           // the hash map had be spilled, it should have enough memory now,
/* 193 */           // try  to allocate buffer again.
/* 194 */           agg_unsafeRowAggBuffer =
/* 195 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value18);
/* 196 */           if (agg_unsafeRowAggBuffer == null) {
/* 197 */             // failed to allocate the first page
/* 198 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 199 */           }
/* 200 */         }
/* 201 */       }
/* 202 */
/* 203 */       if (agg_fastAggBuffer != null) {
/* 204 */         // update fast row
/* 205 */
/* 206 */       } else {
/* 207 */         // update unsafe row
/* 208 */
/* 209 */         // common sub-expressions
/* 210 */
/* 211 */         // evaluate aggregate function
/* 212 */         boolean agg_isNull27 = true;
/* 213 */         double agg_value28 = -1.0;
/* 214 */
/* 215 */         boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 216 */         double agg_value30 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 217 */         boolean agg_isNull28 = agg_isNull29;
/* 218 */         double agg_value29 = agg_value30;
/* 219 */         if (agg_isNull28) {
/* 220 */           boolean agg_isNull30 = false;
/* 221 */           double agg_value31 = -1.0;
/* 222 */           if (!false) {
/* 223 */             agg_value31 = (double) 0;
/* 224 */           }
/* 225 */           if (!agg_isNull30) {
/* 226 */             agg_isNull28 = false;
/* 227 */             agg_value29 = agg_value31;
/* 228 */           }
/* 229 */         }
/* 230 */
/* 231 */         if (!inputadapter_isNull8) {
/* 232 */           agg_isNull27 = false; // resultCode could change nullability.
/* 233 */           agg_value28 = agg_value29 + inputadapter_value8;
/* 234 */
/* 235 */         }
/* 236 */         boolean agg_isNull26 = agg_isNull27;
/* 237 */         double agg_value27 = agg_value28;
/* 238 */         if (agg_isNull26) {
/* 239 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 240 */           double agg_value34 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 241 */           if (!agg_isNull33) {
/* 242 */             agg_isNull26 = false;
/* 243 */             agg_value27 = agg_value34;
/* 244 */           }
/* 245 */         }
/* 246 */         // update unsafe row buffer
/* 247 */         if (!agg_isNull26) {
/* 248 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value27);
/* 249 */         } else {
/* 250 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 251 */         }
/* 252 */
/* 253 */       }
/* 254 */       if (shouldStop()) return;
/* 255 */     }
/* 256 */
/* 257 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 258 */   }
/* 259 */
/* 260 */   private void wholestagecodegen_init_1() {
/* 261 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 262 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 263 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 264 */
/* 265 */   }
/* 266 */
/* 267 */   protected void processNext() throws java.io.IOException {
/* 268 */     if (!agg_initAgg) {
/* 269 */       agg_initAgg = true;
/* 270 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 271 */       agg_doAggregateWithKeys();
/* 272 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 273 */     }
/* 274 */
/* 275 */     // output the result
/* 276 */
/* 277 */     while (agg_mapIter.next()) {
/* 278 */       wholestagecodegen_numOutputRows.add(1);
/* 279 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 280 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 281 */
/* 282 */       boolean agg_isNull34 = agg_aggKey.isNullAt(0);
/* 283 */       UTF8String agg_value35 = agg_isNull34 ? null : (agg_aggKey.getUTF8String(0));
/* 284 */       boolean agg_isNull35 = agg_aggKey.isNullAt(1);
/* 285 */       UTF8String agg_value36 = agg_isNull35 ? null : (agg_aggKey.getUTF8String(1));
/* 286 */       boolean agg_isNull36 = agg_aggKey.isNullAt(2);
/* 287 */       UTF8String agg_value37 = agg_isNull36 ? null : (agg_aggKey.getUTF8String(2));
/* 288 */       boolean agg_isNull37 = agg_aggKey.isNullAt(3);
/* 289 */       int agg_value38 = agg_isNull37 ? -1 : (agg_aggKey.getInt(3));
/* 290 */       boolean agg_isNull38 = agg_aggKey.isNullAt(4);
/* 291 */       UTF8String agg_value39 = agg_isNull38 ? null : (agg_aggKey.getUTF8String(4));
/* 292 */       boolean agg_isNull39 = agg_aggKey.isNullAt(5);
/* 293 */       UTF8String agg_value40 = agg_isNull39 ? null : (agg_aggKey.getUTF8String(5));
/* 294 */       boolean agg_isNull40 = agg_aggKey.isNullAt(6);
/* 295 */       UTF8String agg_value41 = agg_isNull40 ? null : (agg_aggKey.getUTF8String(6));
/* 296 */       boolean agg_isNull41 = agg_aggKey.isNullAt(7);
/* 297 */       UTF8String agg_value42 = agg_isNull41 ? null : (agg_aggKey.getUTF8String(7));
/* 298 */       boolean agg_isNull42 = agg_aggBuffer.isNullAt(0);
/* 299 */       double agg_value43 = agg_isNull42 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 300 */
/* 301 */       if (!(!(agg_isNull42))) continue;
/* 302 */
/* 303 */       boolean filter_isNull2 = false;
/* 304 */
/* 305 */       boolean filter_value2 = false;
/* 306 */       filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value43, 0.0D) > 0;
/* 307 */       if (!filter_value2) continue;
/* 308 */
/* 309 */       filter_numOutputRows.add(1);
/* 310 */
/* 311 */       filter_holder.reset();
/* 312 */
/* 313 */       filter_rowWriter.zeroOutNullBytes();
/* 314 */
/* 315 */       if (agg_isNull34) {
/* 316 */         filter_rowWriter.setNullAt(0);
/* 317 */       } else {
/* 318 */         filter_rowWriter.write(0, agg_value35);
/* 319 */       }
/* 320 */
/* 321 */       filter_rowWriter.write(1, agg_value43);
/* 322 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 323 */       append(filter_result);
/* 324 */
/* 325 */       if (shouldStop()) return;
/* 326 */     }
/* 327 */
/* 328 */     agg_mapIter.close();
/* 329 */     if (agg_sorter == null) {
/* 330 */       agg_hashMap.free();
/* 331 */     }
/* 332 */   }
/* 333 */ }
