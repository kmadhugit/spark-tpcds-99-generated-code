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
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     agg_initAgg = false;
/* 036 */
/* 037 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 038 */
/* 039 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 040 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 041 */     inputadapter_input = inputs[0];
/* 042 */     agg_result = new UnsafeRow(8);
/* 043 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 224);
/* 044 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 045 */
/* 046 */     agg_result1 = new UnsafeRow(2);
/* 047 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 048 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 049 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 050 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 055 */     agg_hashMap = agg_plan.createHashMap();
/* 056 */
/* 057 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 058 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 059 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 060 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 061 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 062 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 063 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 064 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 065 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 066 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 067 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 068 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 069 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 070 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 071 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 072 */       UTF8String inputadapter_value6 = inputadapter_isNull6 ? null : (inputadapter_row.getUTF8String(6));
/* 073 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 074 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 075 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 076 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 077 */
/* 078 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 079 */
/* 080 */       UnsafeRow agg_fastAggBuffer = null;
/* 081 */
/* 082 */       if (agg_fastAggBuffer == null) {
/* 083 */         // generate grouping key
/* 084 */         agg_holder.reset();
/* 085 */
/* 086 */         agg_rowWriter.zeroOutNullBytes();
/* 087 */
/* 088 */         if (inputadapter_isNull) {
/* 089 */           agg_rowWriter.setNullAt(0);
/* 090 */         } else {
/* 091 */           agg_rowWriter.write(0, inputadapter_value);
/* 092 */         }
/* 093 */
/* 094 */         if (inputadapter_isNull1) {
/* 095 */           agg_rowWriter.setNullAt(1);
/* 096 */         } else {
/* 097 */           agg_rowWriter.write(1, inputadapter_value1);
/* 098 */         }
/* 099 */
/* 100 */         if (inputadapter_isNull2) {
/* 101 */           agg_rowWriter.setNullAt(2);
/* 102 */         } else {
/* 103 */           agg_rowWriter.write(2, inputadapter_value2);
/* 104 */         }
/* 105 */
/* 106 */         if (inputadapter_isNull3) {
/* 107 */           agg_rowWriter.setNullAt(3);
/* 108 */         } else {
/* 109 */           agg_rowWriter.write(3, inputadapter_value3);
/* 110 */         }
/* 111 */
/* 112 */         if (inputadapter_isNull4) {
/* 113 */           agg_rowWriter.setNullAt(4);
/* 114 */         } else {
/* 115 */           agg_rowWriter.write(4, inputadapter_value4);
/* 116 */         }
/* 117 */
/* 118 */         if (inputadapter_isNull5) {
/* 119 */           agg_rowWriter.setNullAt(5);
/* 120 */         } else {
/* 121 */           agg_rowWriter.write(5, inputadapter_value5);
/* 122 */         }
/* 123 */
/* 124 */         if (inputadapter_isNull6) {
/* 125 */           agg_rowWriter.setNullAt(6);
/* 126 */         } else {
/* 127 */           agg_rowWriter.write(6, inputadapter_value6);
/* 128 */         }
/* 129 */
/* 130 */         if (inputadapter_isNull7) {
/* 131 */           agg_rowWriter.setNullAt(7);
/* 132 */         } else {
/* 133 */           agg_rowWriter.write(7, inputadapter_value7);
/* 134 */         }
/* 135 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 136 */         agg_value18 = 42;
/* 137 */
/* 138 */         if (!inputadapter_isNull) {
/* 139 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value18);
/* 140 */         }
/* 141 */
/* 142 */         if (!inputadapter_isNull1) {
/* 143 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value18);
/* 144 */         }
/* 145 */
/* 146 */         if (!inputadapter_isNull2) {
/* 147 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value18);
/* 148 */         }
/* 149 */
/* 150 */         if (!inputadapter_isNull3) {
/* 151 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value18);
/* 152 */         }
/* 153 */
/* 154 */         if (!inputadapter_isNull4) {
/* 155 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value18);
/* 156 */         }
/* 157 */
/* 158 */         if (!inputadapter_isNull5) {
/* 159 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value18);
/* 160 */         }
/* 161 */
/* 162 */         if (!inputadapter_isNull6) {
/* 163 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value6.getBaseObject(), inputadapter_value6.getBaseOffset(), inputadapter_value6.numBytes(), agg_value18);
/* 164 */         }
/* 165 */
/* 166 */         if (!inputadapter_isNull7) {
/* 167 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value7, agg_value18);
/* 168 */         }
/* 169 */         if (true) {
/* 170 */           // try to get the buffer from hash map
/* 171 */           agg_unsafeRowAggBuffer =
/* 172 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value18);
/* 173 */         }
/* 174 */         if (agg_unsafeRowAggBuffer == null) {
/* 175 */           if (agg_sorter == null) {
/* 176 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 177 */           } else {
/* 178 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 179 */           }
/* 180 */
/* 181 */           // the hash map had be spilled, it should have enough memory now,
/* 182 */           // try  to allocate buffer again.
/* 183 */           agg_unsafeRowAggBuffer =
/* 184 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value18);
/* 185 */           if (agg_unsafeRowAggBuffer == null) {
/* 186 */             // failed to allocate the first page
/* 187 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 188 */           }
/* 189 */         }
/* 190 */       }
/* 191 */
/* 192 */       if (agg_fastAggBuffer != null) {
/* 193 */         // update fast row
/* 194 */
/* 195 */       } else {
/* 196 */         // update unsafe row
/* 197 */
/* 198 */         // common sub-expressions
/* 199 */
/* 200 */         // evaluate aggregate function
/* 201 */         boolean agg_isNull27 = true;
/* 202 */         double agg_value28 = -1.0;
/* 203 */
/* 204 */         boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 205 */         double agg_value30 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 206 */         boolean agg_isNull28 = agg_isNull29;
/* 207 */         double agg_value29 = agg_value30;
/* 208 */         if (agg_isNull28) {
/* 209 */           boolean agg_isNull30 = false;
/* 210 */           double agg_value31 = -1.0;
/* 211 */           if (!false) {
/* 212 */             agg_value31 = (double) 0;
/* 213 */           }
/* 214 */           if (!agg_isNull30) {
/* 215 */             agg_isNull28 = false;
/* 216 */             agg_value29 = agg_value31;
/* 217 */           }
/* 218 */         }
/* 219 */
/* 220 */         if (!inputadapter_isNull8) {
/* 221 */           agg_isNull27 = false; // resultCode could change nullability.
/* 222 */           agg_value28 = agg_value29 + inputadapter_value8;
/* 223 */
/* 224 */         }
/* 225 */         boolean agg_isNull26 = agg_isNull27;
/* 226 */         double agg_value27 = agg_value28;
/* 227 */         if (agg_isNull26) {
/* 228 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 229 */           double agg_value34 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 230 */           if (!agg_isNull33) {
/* 231 */             agg_isNull26 = false;
/* 232 */             agg_value27 = agg_value34;
/* 233 */           }
/* 234 */         }
/* 235 */         // update unsafe row buffer
/* 236 */         if (!agg_isNull26) {
/* 237 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value27);
/* 238 */         } else {
/* 239 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 240 */         }
/* 241 */
/* 242 */       }
/* 243 */       if (shouldStop()) return;
/* 244 */     }
/* 245 */
/* 246 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 247 */   }
/* 248 */
/* 249 */   protected void processNext() throws java.io.IOException {
/* 250 */     if (!agg_initAgg) {
/* 251 */       agg_initAgg = true;
/* 252 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 253 */       agg_doAggregateWithKeys();
/* 254 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 255 */     }
/* 256 */
/* 257 */     // output the result
/* 258 */
/* 259 */     while (agg_mapIter.next()) {
/* 260 */       wholestagecodegen_numOutputRows.add(1);
/* 261 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 262 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 263 */
/* 264 */       boolean agg_isNull34 = agg_aggKey.isNullAt(0);
/* 265 */       UTF8String agg_value35 = agg_isNull34 ? null : (agg_aggKey.getUTF8String(0));
/* 266 */       boolean agg_isNull35 = agg_aggKey.isNullAt(1);
/* 267 */       UTF8String agg_value36 = agg_isNull35 ? null : (agg_aggKey.getUTF8String(1));
/* 268 */       boolean agg_isNull36 = agg_aggKey.isNullAt(2);
/* 269 */       UTF8String agg_value37 = agg_isNull36 ? null : (agg_aggKey.getUTF8String(2));
/* 270 */       boolean agg_isNull37 = agg_aggKey.isNullAt(3);
/* 271 */       UTF8String agg_value38 = agg_isNull37 ? null : (agg_aggKey.getUTF8String(3));
/* 272 */       boolean agg_isNull38 = agg_aggKey.isNullAt(4);
/* 273 */       UTF8String agg_value39 = agg_isNull38 ? null : (agg_aggKey.getUTF8String(4));
/* 274 */       boolean agg_isNull39 = agg_aggKey.isNullAt(5);
/* 275 */       UTF8String agg_value40 = agg_isNull39 ? null : (agg_aggKey.getUTF8String(5));
/* 276 */       boolean agg_isNull40 = agg_aggKey.isNullAt(6);
/* 277 */       UTF8String agg_value41 = agg_isNull40 ? null : (agg_aggKey.getUTF8String(6));
/* 278 */       boolean agg_isNull41 = agg_aggKey.isNullAt(7);
/* 279 */       int agg_value42 = agg_isNull41 ? -1 : (agg_aggKey.getInt(7));
/* 280 */       boolean agg_isNull42 = agg_aggBuffer.isNullAt(0);
/* 281 */       double agg_value43 = agg_isNull42 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 282 */
/* 283 */       agg_holder1.reset();
/* 284 */
/* 285 */       agg_rowWriter1.zeroOutNullBytes();
/* 286 */
/* 287 */       if (agg_isNull34) {
/* 288 */         agg_rowWriter1.setNullAt(0);
/* 289 */       } else {
/* 290 */         agg_rowWriter1.write(0, agg_value35);
/* 291 */       }
/* 292 */
/* 293 */       if (agg_isNull42) {
/* 294 */         agg_rowWriter1.setNullAt(1);
/* 295 */       } else {
/* 296 */         agg_rowWriter1.write(1, agg_value43);
/* 297 */       }
/* 298 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 299 */       append(agg_result1);
/* 300 */
/* 301 */       if (shouldStop()) return;
/* 302 */     }
/* 303 */
/* 304 */     agg_mapIter.close();
/* 305 */     if (agg_sorter == null) {
/* 306 */       agg_hashMap.free();
/* 307 */     }
/* 308 */   }
/* 309 */ }
