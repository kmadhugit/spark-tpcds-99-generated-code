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
/* 017 */   private UnsafeRow scan_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 021 */   private UnsafeRow filter_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     wholestagecodegen_init_0();
/* 036 */     wholestagecodegen_init_1();
/* 037 */
/* 038 */   }
/* 039 */
/* 040 */   private void wholestagecodegen_init_0() {
/* 041 */     scan_input = inputs[0];
/* 042 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 043 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     scan_scanTime1 = 0;
/* 045 */     scan_batch = null;
/* 046 */     scan_batchIdx = 0;
/* 047 */     scan_colInstance0 = null;
/* 048 */     scan_colInstance1 = null;
/* 049 */     scan_colInstance2 = null;
/* 050 */     scan_result = new UnsafeRow(3);
/* 051 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 052 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 053 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 054 */     filter_result = new UnsafeRow(3);
/* 055 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 056 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 057 */     project_result = new UnsafeRow(2);
/* 058 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 059 */
/* 060 */   }
/* 061 */
/* 062 */   private void scan_nextBatch() throws java.io.IOException {
/* 063 */     long getBatchStart = System.nanoTime();
/* 064 */     if (scan_input.hasNext()) {
/* 065 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 066 */       scan_numOutputRows.add(scan_batch.numRows());
/* 067 */       scan_batchIdx = 0;
/* 068 */       scan_colInstance0 = scan_batch.column(0);
/* 069 */       scan_colInstance1 = scan_batch.column(1);
/* 070 */       scan_colInstance2 = scan_batch.column(2);
/* 071 */
/* 072 */     }
/* 073 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 074 */   }
/* 075 */
/* 076 */   private void wholestagecodegen_init_1() {
/* 077 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   protected void processNext() throws java.io.IOException {
/* 082 */     if (scan_batch == null) {
/* 083 */       scan_nextBatch();
/* 084 */     }
/* 085 */     while (scan_batch != null) {
/* 086 */       int numRows = scan_batch.numRows();
/* 087 */       while (scan_batchIdx < numRows) {
/* 088 */         int scan_rowIdx = scan_batchIdx++;
/* 089 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 090 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 091 */
/* 092 */         boolean filter_value = false;
/* 093 */         boolean filter_isNull = scan_isNull2;
/* 094 */         if (!filter_isNull) {
/* 095 */           if (!filter_value) {
/* 096 */             if (false) {
/* 097 */               filter_isNull = true;
/* 098 */             } else if (scan_value2 == 2000) {
/* 099 */               filter_isNull = false;
/* 100 */               filter_value = true;
/* 101 */             }
/* 102 */           }
/* 103 */
/* 104 */           if (!filter_value) {
/* 105 */             if (false) {
/* 106 */               filter_isNull = true;
/* 107 */             } else if (scan_value2 == 2001) {
/* 108 */               filter_isNull = false;
/* 109 */               filter_value = true;
/* 110 */             }
/* 111 */           }
/* 112 */
/* 113 */           if (!filter_value) {
/* 114 */             if (false) {
/* 115 */               filter_isNull = true;
/* 116 */             } else if (scan_value2 == 2002) {
/* 117 */               filter_isNull = false;
/* 118 */               filter_value = true;
/* 119 */             }
/* 120 */           }
/* 121 */
/* 122 */           if (!filter_value) {
/* 123 */             if (false) {
/* 124 */               filter_isNull = true;
/* 125 */             } else if (scan_value2 == 2003) {
/* 126 */               filter_isNull = false;
/* 127 */               filter_value = true;
/* 128 */             }
/* 129 */           }
/* 130 */
/* 131 */         }
/* 132 */         if (filter_isNull || !filter_value) continue;
/* 133 */
/* 134 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 135 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 136 */
/* 137 */         if (!(!(scan_isNull))) continue;
/* 138 */
/* 139 */         filter_numOutputRows.add(1);
/* 140 */
/* 141 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 142 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 143 */         project_holder.reset();
/* 144 */
/* 145 */         project_rowWriter.zeroOutNullBytes();
/* 146 */
/* 147 */         project_rowWriter.write(0, scan_value);
/* 148 */
/* 149 */         if (scan_isNull1) {
/* 150 */           project_rowWriter.setNullAt(1);
/* 151 */         } else {
/* 152 */           project_rowWriter.write(1, scan_value1);
/* 153 */         }
/* 154 */         project_result.setTotalSize(project_holder.totalSize());
/* 155 */         append(project_result);
/* 156 */         if (shouldStop()) return;
/* 157 */       }
/* 158 */       scan_batch = null;
/* 159 */       scan_nextBatch();
/* 160 */     }
/* 161 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 162 */     scan_scanTime1 = 0;
/* 163 */   }
/* 164 */ }
