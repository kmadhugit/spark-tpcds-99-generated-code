/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private long agg_bufValue2;
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
/* 050 */     agg_result1 = new UnsafeRow(6);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 052 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 6);
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
/* 067 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 068 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 069 */       long inputadapter_value3 = inputadapter_row.getLong(3);
/* 070 */       long inputadapter_value4 = inputadapter_row.getLong(4);
/* 071 */       long inputadapter_value5 = inputadapter_row.getLong(5);
/* 072 */
/* 073 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 074 */
/* 075 */       UnsafeRow agg_fastAggBuffer = null;
/* 076 */
/* 077 */       if (agg_fastAggBuffer == null) {
/* 078 */         // generate grouping key
/* 079 */         agg_holder.reset();
/* 080 */
/* 081 */         agg_rowWriter.zeroOutNullBytes();
/* 082 */
/* 083 */         if (inputadapter_isNull) {
/* 084 */           agg_rowWriter.setNullAt(0);
/* 085 */         } else {
/* 086 */           agg_rowWriter.write(0, inputadapter_value);
/* 087 */         }
/* 088 */
/* 089 */         if (inputadapter_isNull1) {
/* 090 */           agg_rowWriter.setNullAt(1);
/* 091 */         } else {
/* 092 */           agg_rowWriter.write(1, inputadapter_value1);
/* 093 */         }
/* 094 */
/* 095 */         if (inputadapter_isNull2) {
/* 096 */           agg_rowWriter.setNullAt(2);
/* 097 */         } else {
/* 098 */           agg_rowWriter.write(2, inputadapter_value2);
/* 099 */         }
/* 100 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 101 */         agg_value12 = 42;
/* 102 */
/* 103 */         if (!inputadapter_isNull) {
/* 104 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value12);
/* 105 */         }
/* 106 */
/* 107 */         if (!inputadapter_isNull1) {
/* 108 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value12);
/* 109 */         }
/* 110 */
/* 111 */         if (!inputadapter_isNull2) {
/* 112 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value12);
/* 113 */         }
/* 114 */         if (true) {
/* 115 */           // try to get the buffer from hash map
/* 116 */           agg_unsafeRowAggBuffer =
/* 117 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 118 */         }
/* 119 */         if (agg_unsafeRowAggBuffer == null) {
/* 120 */           if (agg_sorter == null) {
/* 121 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 122 */           } else {
/* 123 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 124 */           }
/* 125 */
/* 126 */           // the hash map had be spilled, it should have enough memory now,
/* 127 */           // try  to allocate buffer again.
/* 128 */           agg_unsafeRowAggBuffer =
/* 129 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 130 */           if (agg_unsafeRowAggBuffer == null) {
/* 131 */             // failed to allocate the first page
/* 132 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 133 */           }
/* 134 */         }
/* 135 */       }
/* 136 */
/* 137 */       if (agg_fastAggBuffer != null) {
/* 138 */         // update fast row
/* 139 */
/* 140 */       } else {
/* 141 */         // update unsafe row
/* 142 */
/* 143 */         // common sub-expressions
/* 144 */
/* 145 */         // evaluate aggregate function
/* 146 */         boolean agg_isNull13 = false;
/* 147 */
/* 148 */         long agg_value17 = agg_unsafeRowAggBuffer.getLong(0);
/* 149 */
/* 150 */         long agg_value16 = -1L;
/* 151 */         agg_value16 = agg_value17 + inputadapter_value3;
/* 152 */         boolean agg_isNull16 = false;
/* 153 */
/* 154 */         long agg_value20 = agg_unsafeRowAggBuffer.getLong(1);
/* 155 */
/* 156 */         long agg_value19 = -1L;
/* 157 */         agg_value19 = agg_value20 + inputadapter_value4;
/* 158 */         boolean agg_isNull19 = false;
/* 159 */
/* 160 */         long agg_value23 = agg_unsafeRowAggBuffer.getLong(2);
/* 161 */
/* 162 */         long agg_value22 = -1L;
/* 163 */         agg_value22 = agg_value23 + inputadapter_value5;
/* 164 */         // update unsafe row buffer
/* 165 */         agg_unsafeRowAggBuffer.setLong(0, agg_value16);
/* 166 */         agg_unsafeRowAggBuffer.setLong(1, agg_value19);
/* 167 */         agg_unsafeRowAggBuffer.setLong(2, agg_value22);
/* 168 */
/* 169 */       }
/* 170 */       if (shouldStop()) return;
/* 171 */     }
/* 172 */
/* 173 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 174 */   }
/* 175 */
/* 176 */   protected void processNext() throws java.io.IOException {
/* 177 */     if (!agg_initAgg) {
/* 178 */       agg_initAgg = true;
/* 179 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 180 */       agg_doAggregateWithKeys();
/* 181 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 182 */     }
/* 183 */
/* 184 */     // output the result
/* 185 */
/* 186 */     while (agg_mapIter.next()) {
/* 187 */       wholestagecodegen_numOutputRows.add(1);
/* 188 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 189 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 190 */
/* 191 */       boolean agg_isNull22 = agg_aggKey.isNullAt(0);
/* 192 */       UTF8String agg_value25 = agg_isNull22 ? null : (agg_aggKey.getUTF8String(0));
/* 193 */       boolean agg_isNull23 = agg_aggKey.isNullAt(1);
/* 194 */       UTF8String agg_value26 = agg_isNull23 ? null : (agg_aggKey.getUTF8String(1));
/* 195 */       boolean agg_isNull24 = agg_aggKey.isNullAt(2);
/* 196 */       int agg_value27 = agg_isNull24 ? -1 : (agg_aggKey.getInt(2));
/* 197 */       long agg_value28 = agg_aggBuffer.getLong(0);
/* 198 */       long agg_value29 = agg_aggBuffer.getLong(1);
/* 199 */       long agg_value30 = agg_aggBuffer.getLong(2);
/* 200 */
/* 201 */       agg_holder1.reset();
/* 202 */
/* 203 */       agg_rowWriter1.zeroOutNullBytes();
/* 204 */
/* 205 */       if (agg_isNull22) {
/* 206 */         agg_rowWriter1.setNullAt(0);
/* 207 */       } else {
/* 208 */         agg_rowWriter1.write(0, agg_value25);
/* 209 */       }
/* 210 */
/* 211 */       if (agg_isNull23) {
/* 212 */         agg_rowWriter1.setNullAt(1);
/* 213 */       } else {
/* 214 */         agg_rowWriter1.write(1, agg_value26);
/* 215 */       }
/* 216 */
/* 217 */       if (agg_isNull24) {
/* 218 */         agg_rowWriter1.setNullAt(2);
/* 219 */       } else {
/* 220 */         agg_rowWriter1.write(2, agg_value27);
/* 221 */       }
/* 222 */
/* 223 */       agg_rowWriter1.write(3, agg_value28);
/* 224 */
/* 225 */       agg_rowWriter1.write(4, agg_value29);
/* 226 */
/* 227 */       agg_rowWriter1.write(5, agg_value30);
/* 228 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 229 */       append(agg_result1);
/* 230 */
/* 231 */       if (shouldStop()) return;
/* 232 */     }
/* 233 */
/* 234 */     agg_mapIter.close();
/* 235 */     if (agg_sorter == null) {
/* 236 */       agg_hashMap.free();
/* 237 */     }
/* 238 */   }
/* 239 */ }
