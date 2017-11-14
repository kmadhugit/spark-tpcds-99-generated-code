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
/* 021 */   private int agg_value4;
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
/* 042 */     agg_result = new UnsafeRow(1);
/* 043 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 044 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
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
/* 062 */       long inputadapter_value1 = inputadapter_isNull1 ? -1L : (inputadapter_row.getLong(1));
/* 063 */
/* 064 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 065 */
/* 066 */       UnsafeRow agg_fastAggBuffer = null;
/* 067 */
/* 068 */       if (agg_fastAggBuffer == null) {
/* 069 */         // generate grouping key
/* 070 */         agg_holder.reset();
/* 071 */
/* 072 */         agg_rowWriter.zeroOutNullBytes();
/* 073 */
/* 074 */         if (inputadapter_isNull) {
/* 075 */           agg_rowWriter.setNullAt(0);
/* 076 */         } else {
/* 077 */           agg_rowWriter.write(0, inputadapter_value);
/* 078 */         }
/* 079 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 080 */         agg_value4 = 42;
/* 081 */
/* 082 */         if (!inputadapter_isNull) {
/* 083 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value4);
/* 084 */         }
/* 085 */         if (true) {
/* 086 */           // try to get the buffer from hash map
/* 087 */           agg_unsafeRowAggBuffer =
/* 088 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 089 */         }
/* 090 */         if (agg_unsafeRowAggBuffer == null) {
/* 091 */           if (agg_sorter == null) {
/* 092 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 093 */           } else {
/* 094 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 095 */           }
/* 096 */
/* 097 */           // the hash map had be spilled, it should have enough memory now,
/* 098 */           // try  to allocate buffer again.
/* 099 */           agg_unsafeRowAggBuffer =
/* 100 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 101 */           if (agg_unsafeRowAggBuffer == null) {
/* 102 */             // failed to allocate the first page
/* 103 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 104 */           }
/* 105 */         }
/* 106 */       }
/* 107 */
/* 108 */       if (agg_fastAggBuffer != null) {
/* 109 */         // update fast row
/* 110 */
/* 111 */       } else {
/* 112 */         // update unsafe row
/* 113 */
/* 114 */         // common sub-expressions
/* 115 */
/* 116 */         // evaluate aggregate function
/* 117 */         boolean agg_isNull6 = true;
/* 118 */         long agg_value7 = -1L;
/* 119 */
/* 120 */         boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 121 */         long agg_value9 = agg_isNull8 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 122 */         boolean agg_isNull7 = agg_isNull8;
/* 123 */         long agg_value8 = agg_value9;
/* 124 */         if (agg_isNull7) {
/* 125 */           boolean agg_isNull9 = false;
/* 126 */           long agg_value10 = -1L;
/* 127 */           if (!false) {
/* 128 */             agg_value10 = (long) 0;
/* 129 */           }
/* 130 */           if (!agg_isNull9) {
/* 131 */             agg_isNull7 = false;
/* 132 */             agg_value8 = agg_value10;
/* 133 */           }
/* 134 */         }
/* 135 */
/* 136 */         if (!inputadapter_isNull1) {
/* 137 */           agg_isNull6 = false; // resultCode could change nullability.
/* 138 */           agg_value7 = agg_value8 + inputadapter_value1;
/* 139 */
/* 140 */         }
/* 141 */         boolean agg_isNull5 = agg_isNull6;
/* 142 */         long agg_value6 = agg_value7;
/* 143 */         if (agg_isNull5) {
/* 144 */           boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 145 */           long agg_value13 = agg_isNull12 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 146 */           if (!agg_isNull12) {
/* 147 */             agg_isNull5 = false;
/* 148 */             agg_value6 = agg_value13;
/* 149 */           }
/* 150 */         }
/* 151 */         // update unsafe row buffer
/* 152 */         if (!agg_isNull5) {
/* 153 */           agg_unsafeRowAggBuffer.setLong(0, agg_value6);
/* 154 */         } else {
/* 155 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 156 */         }
/* 157 */
/* 158 */       }
/* 159 */       if (shouldStop()) return;
/* 160 */     }
/* 161 */
/* 162 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 163 */   }
/* 164 */
/* 165 */   protected void processNext() throws java.io.IOException {
/* 166 */     if (!agg_initAgg) {
/* 167 */       agg_initAgg = true;
/* 168 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 169 */       agg_doAggregateWithKeys();
/* 170 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 171 */     }
/* 172 */
/* 173 */     // output the result
/* 174 */
/* 175 */     while (agg_mapIter.next()) {
/* 176 */       wholestagecodegen_numOutputRows.add(1);
/* 177 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 178 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 179 */
/* 180 */       boolean agg_isNull13 = agg_aggKey.isNullAt(0);
/* 181 */       UTF8String agg_value14 = agg_isNull13 ? null : (agg_aggKey.getUTF8String(0));
/* 182 */       boolean agg_isNull14 = agg_aggBuffer.isNullAt(0);
/* 183 */       long agg_value15 = agg_isNull14 ? -1L : (agg_aggBuffer.getLong(0));
/* 184 */
/* 185 */       agg_holder1.reset();
/* 186 */
/* 187 */       agg_rowWriter1.zeroOutNullBytes();
/* 188 */
/* 189 */       if (agg_isNull13) {
/* 190 */         agg_rowWriter1.setNullAt(0);
/* 191 */       } else {
/* 192 */         agg_rowWriter1.write(0, agg_value14);
/* 193 */       }
/* 194 */
/* 195 */       if (agg_isNull14) {
/* 196 */         agg_rowWriter1.setNullAt(1);
/* 197 */       } else {
/* 198 */         agg_rowWriter1.write(1, agg_value15);
/* 199 */       }
/* 200 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 201 */       append(agg_result1);
/* 202 */
/* 203 */       if (shouldStop()) return;
/* 204 */     }
/* 205 */
/* 206 */     agg_mapIter.close();
/* 207 */     if (agg_sorter == null) {
/* 208 */       agg_hashMap.free();
/* 209 */     }
/* 210 */   }
/* 211 */ }
